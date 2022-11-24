package com.example.noodle.controller;

import com.example.noodle.model.User;
import com.example.noodle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
    UserService userService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> getPage(){
        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
    }

    @GetMapping(value = "/{users}")
    public List<User> getUsers(){
        userService.findAll();
        return null;
    }
//
//    @PostMapping(value = "/save")
//    public String saveUser(@RequestBody User user){
//        userRepo.save(user);
//        return "Saved...";
//    }
//
//    @PutMapping(value = "update/{id}")
//    public String updateUser(@PathVariable long id, @RequestBody User user){
//        User updatedUser = userRepo.findById(id).get();
//        updatedUser.setId(user.getId());
//        updatedUser.setUsername(user.getUsername());
//        updatedUser.setPassword(user.getPassword());
//        updatedUser.setRole(user.getRole());
//        userRepo.save(updatedUser);
//        return "Updated..";
//    }
//    @DeleteMapping(value = "/delete/{id}")
//    public String deleteUser(@PathVariable long id){
//        User deletedUser = userRepo.findById(id).get();
//        userRepo.delete(deletedUser);
//        return "User with id " + id + " has been deleted.";
//    }
}