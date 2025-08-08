package com.mohan.example.controller;

import com.mohan.example.entities.*;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.mohan.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public String createQuiz(@RequestParam String category, @RequestParam @Min(1) @Max(10) int numQ, @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("/{id}")
    public List<QuestionWrapper> getQuiz(@PathVariable Long id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public Integer submitQuiz(@PathVariable Long id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }
}
