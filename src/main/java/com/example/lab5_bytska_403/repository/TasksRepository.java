package com.example.lab5_bytska_403.repository;


import com.example.lab5_bytska_403.entity.Tasks;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TasksRepository extends ReactiveCrudRepository<Tasks, Long> {
}
