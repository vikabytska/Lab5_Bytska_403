package com.example.lab5_bytska_403.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor

@Table(name = "tasks")
public class Tasks {
    private long id;
    private String title;
    private String description;
    private long courseId; // Пов'язано з одним курсом (1:Б)
    private int maxScore;
}
