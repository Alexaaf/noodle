package com.example.noodle.repo;

import com.example.noodle.model.Grade;
import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long > {
    Grade findGradeByStudentID(String id);
    @Override
    Grade save (Grade grade);
}
