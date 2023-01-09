package com.example.noodle.repo;

import com.example.noodle.model.Answers;
import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswersRepository extends JpaRepository<Answers, Long > {
    @Query("SELECT e FROM Answers e WHERE e.quizId = :id")
    public List<Answers> findAnswersByQuizId(@Param("id") int id);
    @Override
    Answers save (Answers answers);

}
