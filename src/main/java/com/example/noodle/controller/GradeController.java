package com.example.noodle.controller;

import com.example.noodle.model.Grade;
import com.example.noodle.model.User;
import com.example.noodle.service.GradeService;
import com.example.noodle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
@CrossOrigin
public class GradeController {
    @Autowired
    GradeService gradeService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> getPage(){
        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
    }

    @GetMapping(value = "/allGrades")
    public List<Grade> getGrades(){
        return  gradeService.findAll();
    }

    @PostMapping(value = "/addGrade")
    public String addGrade(@RequestBody Grade grade)
    {
        try{
            gradeService.saveGrade(grade);
            return "New grade added";
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return e.toString();
        }

    }
}
