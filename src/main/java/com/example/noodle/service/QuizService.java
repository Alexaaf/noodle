package com.example.noodle.service;

import com.example.noodle.model.Quiz;
import com.example.noodle.repo.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizService {

    QuizRepository quizRepository;

    public List<Quiz> findAll(){
        return quizRepository.findAll();
    }

    public Quiz saveQuiz(Quiz quiz) {

        return quizRepository.save(quiz);
    }
}
