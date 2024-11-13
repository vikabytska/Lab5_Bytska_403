package com.example.lab5_bytska_403.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor

@Table(name = "courses")
public class Courses {
    private Long id;
    private String title;
    private String description;
    private Long tutorId;
}
