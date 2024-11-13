package com.example.lab5_bytska_403.service;



import com.example.lab5_bytska_403.entity.Tutors;
import com.example.lab5_bytska_403.repository.TutorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TutorsService {

    private final TutorsRepository tutorsRepository;

    public Flux<Tutors> findAll() {
        return tutorsRepository.findAll();
    }

    public Mono<Tutors> findTutorById(long id) {
        return tutorsRepository.findById(id);
    }

    public Mono<Tutors> save(Tutors tutors) {
        return tutorsRepository.save(tutors);
    }

    public Mono<Void> deleteTutorById(long id) {
        return tutorsRepository.deleteById(id);
    }

    public Mono<Tutors> update(Tutors tutors) {
        return tutorsRepository.save(tutors);
    }



}
