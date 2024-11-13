package com.example.lab5_bytska_403.router;

import com.example.lab5_bytska_403.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        RequestPredicate acceptJson = accept(MediaType.APPLICATION_JSON);
        return RouterFunctions
                .route(RequestPredicates.GET("/main").or(RequestPredicates.GET("/")).and(acceptJson), greetingHandler::main)
                .andRoute(RequestPredicates.GET("/users").and(acceptJson), greetingHandler::users)
                .andRoute(RequestPredicates.GET("/admin"), greetingHandler::admin)
                .andRoute(RequestPredicates.GET("/registration"), greetingHandler::registration);
    }


}
