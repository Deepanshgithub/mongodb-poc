package com.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AttendanceServiceInterface {

  Mono<Attendance> saveAttendance(Attendance attendance);

  Flux<Attendance> getAttendance();

  Flux<Employee> getEmployeeByTech(String technology);

  Flux<Employee> getEmployeeWithMaximumAttendance();
}