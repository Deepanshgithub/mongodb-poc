package com.example;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
  Mono<Void> deleteById(String id);
  Mono<Employee> findById(String id);
  Mono<Employee> findByEmail(String email);
  Flux<Employee> findByState(String state);


}