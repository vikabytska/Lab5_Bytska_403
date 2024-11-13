package com.example.lab5_bytska_403.repository;

import com.example.lab5_bytska_403.entity.Marks;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MarksRepository extends ReactiveCrudRepository<Marks, Long> {
    Flux<Marks> findByStudentId(Long studentId);
    Flux<Marks> findByTaskId(Long taskId);
}
