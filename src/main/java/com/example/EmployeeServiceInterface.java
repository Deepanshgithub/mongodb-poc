package com.example;

import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeServiceInterface {
  Flux<Employee> getEmployee();
  Mono<Employee> saveEmployee(Employee employee);
  Mono<Employee> findById(String id);
  Mono<Void> deleteById(String id);
  Flux<Employee> getEmployeeByName(String firstName, String lastName);
  Mono<Employee> updateEmployeeById(String id, Employee employee);
  Mono<Map<String, String>> getEmployeeCountByState();
  Mono<Integer> getTotalSalary();
}