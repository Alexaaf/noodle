package com.example.noodle.service;

import com.example.noodle.model.Grade;
import com.example.noodle.model.User;
import com.example.noodle.repo.GradeRepository;
import com.example.noodle.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    public List<Grade> findAll(){
        return gradeRepository.findAll();
    }

    public Grade saveGrade(Grade grade) {

        return gradeRepository.save(grade);
    }

    public List <Grade> findGradeByStudentId(String id, String course) {
        return gradeRepository.findGradeByStudentId(id, course);
    }
}
