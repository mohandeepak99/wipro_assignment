package com.mohan.example.service;

import com.mohan.example.entities.*;
import com.mohan.example.entities.*;
import com.mohan.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    // same behavior as your current impl
    public String createQuiz(String category, int numQ, String title) {
        List<Question> questions =
                questionRepository.findRandomQuestionsByCategory(category.toUpperCase(), numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepository.save(quiz);
        return "Quiz Created!";
    }

    public List<QuestionWrapper> getQuizQuestions(Long id) {
        List<Question> questions = quizRepository.findById(id).get().getQuestions();
        List<QuestionWrapper> wrappers = new ArrayList<>();
        for (Question q : questions) {
            wrappers.add(new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            ));
        }
        return wrappers;
    }

    public Integer calculateResult(Long id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int score = 0;
        int limit = Math.min(responses.size(), questions.size());
        for (int i = 0; i < limit; i++) {
            if (responses.get(i).getUserAnswer()
                    .equalsIgnoreCase(questions.get(i).getCorrectAnswer())) {
                score++;
            }
        }
        return score;
    }
}