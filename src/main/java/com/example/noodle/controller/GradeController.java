package com.example.noodle.controller;

import com.example.noodle.model.Grade;
import com.example.noodle.model.User;
import com.example.noodle.service.GradeService;
import com.example.noodle.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
@CrossOrigin
@AllArgsConstructor
public class GradeController {

    GradeService gradeService;

//    @GetMapping
//    public ResponseEntity<String> getPage(){
//        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
//    }

    @GetMapping
    public List<Grade> getGrades(){
        System.out.println("grades");
        return  gradeService.findAll();
    }

    @PostMapping
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

    @RequestMapping (value = "findByStudentId/{id}/{course}")
    public List<Grade> getGradeByStudentId(@PathVariable String id,@PathVariable String course){
        return gradeService.findGradeByStudentId(id,course);
    }
}
