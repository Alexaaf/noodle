package com.example.noodle.repo;

import com.example.noodle.model.Quiz;
import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long > {
    Quiz findUserByCourse(String course);
    @Override
    Quiz save (Quiz quiz);
}
