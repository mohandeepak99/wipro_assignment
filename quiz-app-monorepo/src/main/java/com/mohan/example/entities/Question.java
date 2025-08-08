package com.mohan.example.entities;

import com.mohan.example.enums.*;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

    @Enumerated(EnumType.ORDINAL)
    private Difficulty difficultyLevel;

    @Enumerated(EnumType.ORDINAL)
    private Category category;

}
