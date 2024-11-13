package com.example.lab5_bytska_403.repository;

import com.example.lab5_bytska_403.entity.Tutors;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TutorsRepository extends ReactiveCrudRepository<Tutors, Long> {
}
