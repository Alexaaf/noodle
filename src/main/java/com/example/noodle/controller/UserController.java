package com.example.noodle.controller;

import com.example.noodle.dto.SaveUserRequest;
import com.example.noodle.model.User;
import com.example.noodle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "/test")
    public ResponseEntity<String> getPage() {
        return new ResponseEntity<String>("Welcome", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody SaveUserRequest user) {
        try {
            User dbUser = new User(user.getEmail(),
                    bCryptPasswordEncoder.encode(user.getPassword()), user.getRole());
            System.out.println(dbUser.getEmail() + " | " + dbUser.getPassword()+" | "+dbUser.getRole());
            userService.saveUser(dbUser);
            return "New user added";
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }

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