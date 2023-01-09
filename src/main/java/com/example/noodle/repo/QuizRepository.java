package com.example.noodle.repo;

import com.example.noodle.model.Answers;
import com.example.noodle.model.Quiz;
import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long > {
    @Override
    Quiz save (Quiz quiz);

    @Query("SELECT e FROM Quiz e WHERE e.course = :course")
    public List<Quiz> findByCourse(@Param("course") String course);

    @Query("SELECT id FROM Quiz WHERE id=(SELECT max(id) FROM Quiz)")
    public int getLastQuiz();

}
