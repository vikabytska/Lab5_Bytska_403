package com.example.lab5_bytska_403.controller;


import com.example.lab5_bytska_403.entity.Students;
import com.example.lab5_bytska_403.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsService studentsService;

    @GetMapping("/students")
    public Flux<Students> getAllStudents() {
        return studentsService.findAll();
    }
}
