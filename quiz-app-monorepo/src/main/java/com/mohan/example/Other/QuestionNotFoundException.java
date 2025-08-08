package com.mohan.example.Other;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(Long id) {
        super("Question not found with ID: " + id);
    }
}
