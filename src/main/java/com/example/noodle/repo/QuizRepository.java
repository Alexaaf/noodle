package com.example.noodle.repo;

import com.example.noodle.model.Answers;
import com.example.noodle.model.Quiz;
import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long > {
    Optional<Quiz> findUserByCourse(String course);
}
