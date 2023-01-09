package com.example.noodle.controller;

import com.example.noodle.model.PersonalInformation;
import com.example.noodle.model.User;
import com.example.noodle.service.PersonalInformationService;
import com.example.noodle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
@CrossOrigin
public class PersonalInformationController {

    @Autowired
    PersonalInformationService informationService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> getPage(){
        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<PersonalInformation> getInfo(){
        return  informationService.findAll();
    }

    @PostMapping(value = "/addInfo")
    public String addInfo(@RequestBody PersonalInformation information)
    {
        try{
            informationService.saveInfo(information);
            return "New user information added";
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return e.toString();
        }
    }

    @RequestMapping (value = "findInfoByStudentId/{id}")
    public List<PersonalInformation> getInfoByStudentId(@PathVariable Long id){
        return informationService.findById(id);
    }

}
