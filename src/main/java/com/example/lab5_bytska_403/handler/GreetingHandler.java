package com.example.lab5_bytska_403.handler;

import com.example.lab5_bytska_403.entity.Role;
import com.example.lab5_bytska_403.entity.User;
import com.example.lab5_bytska_403.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class GreetingHandler {
    private final UserService userService;

    public GreetingHandler(UserService userService) {
        this.userService = userService;
    }


    public Mono<ServerResponse> main(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(fromValue("Main page"));
    }
    public Mono<ServerResponse> users(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue("User page"));
    }

    public Mono<ServerResponse> admin(ServerRequest request) {

            Flux<User> users = Flux.just(
                    new User(1L, "1111", "1111", Role.ROLE_ADMIN),
                    new User(2L, "2222", "2222", Role.ROLE_USER),
                    new User(3L, "ivan_petrov", "password123", Role.ROLE_USER),
                    new User(4L, "elena_sidorova", "qwerty789", Role.ROLE_USER),
                    new User(5L, "user", "111", Role.ROLE_USER),
                    new User(6L, "sergey_kuznetsov", "securePass", Role.ROLE_USER),
                    new User(7L, "maria_orlova", "mypass1234", Role.ROLE_USER)
            );

            return ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(users, User.class);
        }

        public Mono<ServerResponse> registration(ServerRequest request) {
        return ServerResponse
                .ok()
                .render("registration");
    }

}
