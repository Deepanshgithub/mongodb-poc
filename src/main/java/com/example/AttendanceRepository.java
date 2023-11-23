package com.example;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AttendanceRepository extends ReactiveMongoRepository<Attendance, String> {
  Flux<Attendance> findByTechnology(String technology);

}