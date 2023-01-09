package com.example.noodle.repo;

import com.example.noodle.model.Grade;
import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long > {
    @Override
    Grade save (Grade grade);

    @Query("SELECT e FROM Grade e WHERE e.studentID = :id and e.course = :course")
    public List<Grade> findGradeByStudentId(@Param("id") String id, @Param("course") String course);
}
