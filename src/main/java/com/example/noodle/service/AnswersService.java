package com.example.noodle.service;

import com.example.noodle.model.Answers;
import com.example.noodle.model.User;
import com.example.noodle.repo.AnswersRepository;
import com.example.noodle.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersService {

    @Autowired
    AnswersRepository answersRepository;

    public List<Answers> findAll(){
        return answersRepository.findAll();
    }

    public Answers saveAnswers(Answers answers) {

        return answersRepository.save(answers);
    }

    public List <Answers> findAnswersByQuizId(int id) {
        return answersRepository.findAnswersByQuizId(id);
    }

}
