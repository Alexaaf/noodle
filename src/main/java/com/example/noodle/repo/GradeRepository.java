package com.example.noodle.repo;

import com.example.noodle.model.Grade;
import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long > {
    Optional<Grade> findGradeByStudentID(String id);
}
