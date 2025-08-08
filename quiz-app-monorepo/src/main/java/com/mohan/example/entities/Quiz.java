package com.mohan.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.mohan.example.entities.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    private List<Question> questions;
}
