package com.example.lab5_bytska_403.controller;

import com.example.lab5_bytska_403.entity.Role;
import com.example.lab5_bytska_403.entity.User;
import com.example.lab5_bytska_403.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    public final UserService userService;


    @PostMapping("/registration")
    public Mono<User> addNewUser(@RequestBody User user) {
        user.setRole(Role.ROLE_USER);
        return userService.addNewUser(user);
    }

}
