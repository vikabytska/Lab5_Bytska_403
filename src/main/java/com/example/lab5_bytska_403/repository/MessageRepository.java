package com.example.lab5_bytska_403.repository;


import com.example.lab5_bytska_403.entity.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}
