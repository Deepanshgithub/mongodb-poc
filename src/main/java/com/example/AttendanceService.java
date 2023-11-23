package com.example;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class AttendanceService implements AttendanceServiceInterface {

  @Autowired
  private EmployeeRepository employeeRepository;


  @Autowired
  private AttendanceRepository attendanceRepository;

  @Override
  public Mono<Attendance> saveAttendance(Attendance attendance) {
    return attendanceRepository.save(attendance);
  }

  @Override
  public Flux<Attendance> getAttendance() {
    return attendanceRepository.findAll();
  }

  @Override
  public Flux<Employee> getEmployeeByTech(String technology){
    return attendanceRepository.findByTechnology(technology).distinct(Attendance::getEmail)
        .flatMap(attendance -> {
          return employeeRepository.findByEmail(attendance.getEmail());
        }).switchIfEmpty( Mono.defer(() -> {
          return Mono.error(new EmployeeException("No Employee exists for this Technology"));
        }));
  }


  @Override
  public Flux<Employee> getEmployeeWithMaximumAttendance(){
    return attendanceRepository.findAll()
        .groupBy(Attendance::getEmail)
        .flatMap(stringAttendanceGroupedFlux -> {
          return stringAttendanceGroupedFlux.map(Attendance::getEmail).count()
              .map(count -> count + " " + stringAttendanceGroupedFlux.key());
        }).collectMap(entity -> {
          return entity.split(" ")[1];
        }, entity -> {
          return Integer.parseInt(entity.split(" ")[0]);
        })
        .map(stringIntegerMap -> {
          return Collections.max(stringIntegerMap.keySet());
        })
        .flux()
        .flatMap(email -> {
          return employeeRepository.findByEmail(email);
        });

  }


}