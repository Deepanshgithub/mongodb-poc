package com.example;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MappingRepositoryInterface extends ReactiveMongoRepository<NoteUserMapping,String> {
  Flux<NoteUserMapping> findByUserId(String validToken);

  Flux<NoteUserMapping> deleteByNoteId(String noteId);

  Mono<NoteUserMapping> findByNoteIdAndUserId(String validToken, String noteId);
}