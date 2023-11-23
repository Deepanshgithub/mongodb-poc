package com.example;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements EmployeeServiceInterface {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Mono<Employee> saveEmployee(Employee employee){
    return employeeRepository.save(employee)
        .switchIfEmpty( Mono.defer(() -> {
          return Mono.error(new EmployeeException("<><><><><><><>"));
        }));
  }

  @Override
  public Flux<Employee> getEmployee() {
    return employeeRepository.findAll();

  }

  public Flux<Employee> getEmployeeByName(String firstName, String lastName){
    return employeeRepository.findAll()
        .filter(emp -> emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName))
        .switchIfEmpty( Mono.defer(() -> {
          return Mono.error(new EmployeeException("First Name and Last Name NOT FOUND...!!"));
        }));

  }

  @Override
  public Mono<Employee> updateEmployeeById(String id, Employee employee){
    deleteById(id);
    employee.setId(id);
    return employeeRepository.save(employee);

  }

  public Mono<Employee> findById(String id){
    return employeeRepository.findById(id)
        .switchIfEmpty( Mono.defer(() -> {
          return Mono.error(new EmployeeException(" Employee Id does not Exist "));
        }));
  }

  public Mono<Void> deleteById(String id){
    return employeeRepository.deleteById(id)
        .switchIfEmpty( Mono.defer(() -> {
          return Mono.error(new EmployeeException(" Employee Id does not Exist "));
        }));
  }

  public Mono<Map<String, String>> getEmployeeCountByState(){
    return employeeRepository.findAll().groupBy(Employee::getState)
        .flatMap(stringEmployeeGroupedFlux -> stringEmployeeGroupedFlux.count()
            .map(count -> count + " " + stringEmployeeGroupedFlux.key()))
        .collectMap(
            entity -> entity.split( " ")[1],
            entity -> entity.split(" ") [0]

        );


  }

  public Mono<Integer> getTotalSalary() {
    return employeeRepository.findAll()
        .map(employee-> {
          if (employee.getSalary()==null)
            return 0;
          return Integer.parseInt(employee.getSalary());
        })
        .reduce(Integer::sum);
  }
}