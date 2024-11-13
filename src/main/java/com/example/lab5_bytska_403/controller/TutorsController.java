package com.example.lab5_bytska_403.controller;


import com.example.lab5_bytska_403.entity.Tutors;
import com.example.lab5_bytska_403.service.TutorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class TutorsController {

    private final TutorsService tutorsService;

    @GetMapping("/tutors")
    public Flux<Tutors> getAllTutors() {
        return tutorsService.findAll();
    }

    @PostMapping("/tutors")
    public Mono<Tutors> saveTutors(@RequestBody Tutors tutors) {
        return tutorsService.save(tutors);
    }

}
