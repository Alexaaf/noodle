package com.example.noodle.controller;

import com.example.noodle.model.Answers;
import com.example.noodle.model.Quiz;
import com.example.noodle.model.User;
import com.example.noodle.service.QuizService;
import com.example.noodle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
    @RequestMapping("/quiz")
    @CrossOrigin
    public class QuizController {

        @Autowired
        QuizService quizService;

        @GetMapping(value = "/test")
        public ResponseEntity<String> getPage() {
            return new ResponseEntity<String>("Quiz test", HttpStatus.OK);
        }

        @GetMapping(value = "/allQuizes")
        public List<Quiz> getQuizes() {
            return quizService.findAll();
        }

        @PostMapping(value = "/addQuiz")
        public String addQuiz(@RequestBody Quiz quiz) {
            try {
                quizService.saveQuiz(quiz);
                return "New quiz added";
            } catch (Exception e) {
                System.out.println(e.toString());
                return e.toString();
            }

        }

        @RequestMapping (value = "findQuizByCourse/{course}")
        public List<Quiz> getQuizByCourse(@PathVariable String course){
            List<Quiz> list = quizService.findByCourse(course);
            Random rand = new Random();
            List<Quiz> q = new ArrayList<>();
            q.add(list.get(rand.nextInt(list.size())));
            return q;
        }

    @RequestMapping (value = "getLastQuiz")
    public int getLastQuiz(){
        return quizService.getLastQuiz();
    }
    }
