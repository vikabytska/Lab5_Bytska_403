package com.example.lab5_bytska_403.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.userdetails.User;


@Data
@NoArgsConstructor

@Table(name = "tutors")
public class Tutors {


    @Id
    private long id;
    private String firstName;
    private String lastName;
    private User user;
    private long userId;


}
