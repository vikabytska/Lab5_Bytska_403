package com.example.lab5_bytska_403.controller;


import com.example.lab5_bytska_403.entity.Marks;
import com.example.lab5_bytska_403.service.MarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MarksController {

    private final MarksService marksService;
    @GetMapping("/marks")
    public Flux<Marks> getAllMarks() {
        return marksService.findAll();
    }

    @PostMapping("/marks")
    public Mono<Marks> saveMarks(@RequestBody Marks marks) {
        return marksService.save(marks);
    }

}
