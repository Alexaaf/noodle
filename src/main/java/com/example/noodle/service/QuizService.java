package com.example.noodle.service;

import com.example.noodle.model.Quiz;
import com.example.noodle.repo.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    public List<Quiz> findAll(){
        return quizRepository.findAll();
    }

    public Quiz saveQuiz(Quiz quiz) {

        return quizRepository.save(quiz);
    }
}
