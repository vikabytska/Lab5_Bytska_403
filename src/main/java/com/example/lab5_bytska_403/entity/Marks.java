package com.example.lab5_bytska_403.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor

@Table(name = "marks")
public class Marks {
    private long id;
    private long taskId;
    private long studentId;
    private int mark;

}
