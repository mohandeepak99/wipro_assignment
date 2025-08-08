package com.mohan.example.controller;

import com.mohan.example.entities.*;
import com.mohan.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    
    @GetMapping("/paged")
    public Page<Question> getQuestionsPaged(@RequestParam int page, @RequestParam int size) {
        return questionService.getQuestionsPaged(page, size);
    }

    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
    
    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return "Question with ID " + id + " deleted successfully.";
    }
    
    @PatchMapping("/{id}/title")
    public Question updateTitle(@PathVariable Long id, @RequestBody String newTitle) {
        return questionService.updateQuestionTitle(id, newTitle);
    }

    @PatchMapping("/{id}/answer")
    public Question updateAnswer(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        String newAnswer = payload.get("answer");
        return questionService.updateCorrectAnswer(id, newAnswer);
    }


}
