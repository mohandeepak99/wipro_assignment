package com.mohan.example.service;

import com.mohan.example.entities.*;
import com.mohan.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.mohan.example.Other.*;

import java.util.List;


@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        Question existing = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
        questionRepository.delete(existing);
    }

    public Question updateQuestionTitle(Long id, String newTitle) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
        question.setQuestionTitle(newTitle);
        return questionRepository.save(question);
    }

    public Question updateCorrectAnswer(Long id, String newAnswer) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
        question.setCorrectAnswer(newAnswer);
        return questionRepository.save(question);
    }

    public Page<Question> getQuestionsPaged(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size));
    }
}