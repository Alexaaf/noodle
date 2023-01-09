package com.example.noodle.controller;

import com.example.noodle.model.Answers;
import com.example.noodle.model.User;
import com.example.noodle.service.AnswersService;
import com.example.noodle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@CrossOrigin
public class AnswersController {

    @Autowired
    AnswersService answersService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> getPage(){
        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<Answers> getAnswers(){
        return  answersService.findAll();
    }


    @PostMapping(value = "/addAnswers")
    public String addAnswers(@RequestBody Answers answers)
    {
        try{
            answersService.saveAnswers(answers);
            return "New answers added";
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return e.toString();
        }

    }

    @RequestMapping (value = "findByQuizId/{id}")
    public List<Answers> getAnswersByQuizId(@PathVariable int id){
        return answersService.findAnswersByQuizId(id);
    }

}
