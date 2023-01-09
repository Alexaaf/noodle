package com.example.noodle.service;

import com.example.noodle.model.Grade;

import java.util.List;

public interface IGradeService {
    Grade saveGrade(Grade grade);
    List<Grade> findAll();
}
