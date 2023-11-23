package com.example;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class EmployeeController {

  @Autowired
  private EmployeeServiceInterface employeeService;

  @Autowired
  private AttendanceServiceInterface attendanceService;

  @GetMapping("employees")
  public Flux<Employee> getEmployee() {
    return employeeService.getEmployee();
  }

  @GetMapping("employee/id")
  public Mono<Employee> getEmployeeById(@RequestParam("id") String id) {
    return employeeService.findById(id);
  }

  @GetMapping("employee/name")
  public Flux<Employee> getEmployeeByName(@Valid @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName){
    return  employeeService.getEmployeeByName(firstName,lastName);

  }

  @GetMapping("employee-count/state")
  public Mono<Map<String, String>> getEmployeeCountByState(){
    return employeeService.getEmployeeCountByState();
  }

  @GetMapping("employees/tech")
  public Flux<Employee> getEmployee(@RequestParam("technology") String technology){
    return attendanceService.getEmployeeByTech(technology);
  }

  @GetMapping("employee/max-attendance")
  public Flux<Employee> getEmployeeWithMaximumAttendance(){
    return attendanceService.getEmployeeWithMaximumAttendance();
  }

  @GetMapping("employee/salary")
  public Mono<Integer> getEmployeeSalary(){
    return employeeService.getTotalSalary();
  }

  @PostMapping(value = "employee", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Response>> saveEmployee(@Valid @RequestBody Mono<Employee> employee){
    return  employee.flatMap(employeeObj -> employeeService.saveEmployee(employeeObj)
        .map(savedEmployee -> {
          Response response = new Response(200,"Employee added Successfully",savedEmployee);
          return ResponseEntity.ok(response);
        }));

  }

  @PutMapping(value = "employee/id", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Response>> updateEmployeeById(@RequestParam("id") String id,@Valid @RequestBody Mono<Employee> employee){
    return  employee.flatMap(employeeObj -> employeeService.updateEmployeeById(id, employeeObj)
        .map(savedEmployee -> {
          Response response = new Response(200,"Employee updated Successfully",savedEmployee);
          return ResponseEntity.ok(response);
        }));
  }




  @DeleteMapping("employee/id")
  public Mono<Void> deleteEmployee(@RequestParam("id") String id){
    return employeeService.deleteById(id);

  }



  @PostMapping("attendance")
  public Mono<Attendance> saveAttendance(@RequestBody Attendance attendance){
    return  attendanceService.saveAttendance(attendance);
  }

  @GetMapping("attendance")
  public Flux<Attendance> getAttendance() {
    return attendanceService.getAttendance();
  }





}