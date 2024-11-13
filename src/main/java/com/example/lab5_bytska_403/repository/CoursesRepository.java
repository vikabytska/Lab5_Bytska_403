package com.example.lab5_bytska_403.repository;


import com.example.lab5_bytska_403.entity.Courses;
import com.example.lab5_bytska_403.entity.Marks;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CoursesRepository extends ReactiveCrudRepository<Courses, Long> {
    Flux<Marks> findByTutorId(Long tutorId);
}
