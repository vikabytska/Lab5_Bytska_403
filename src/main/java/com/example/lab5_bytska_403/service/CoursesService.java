package com.example.lab5_bytska_403.service;


import com.example.lab5_bytska_403.entity.Courses;
import com.example.lab5_bytska_403.repository.CoursesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CoursesService {

    private final CoursesRepository coursesRepository;

    public Flux<Courses> findAll() {
        return coursesRepository.findAll();
    }

    public Mono<Courses> findById(Long id) {
        return coursesRepository.findById(id);
    }

    public Mono<Courses> save(Courses courses) {
        return coursesRepository.save(courses);
    }

    public Mono<Void> deleteById(Long id) {
        return coursesRepository.deleteById(id);
    }

    public Mono<Courses> update(Courses courses) {
        return coursesRepository.save(courses);
    }

}
