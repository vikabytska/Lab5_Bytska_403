package com.example.lab5_bytska_403.repository;

import com.example.lab5_bytska_403.entity.Students;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StudentsRepository extends ReactiveCrudRepository<Students, Long> {
}
