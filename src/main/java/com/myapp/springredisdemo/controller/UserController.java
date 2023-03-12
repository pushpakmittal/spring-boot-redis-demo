package com.myapp.springredisdemo.controller;

import com.myapp.springredisdemo.model.User;
import com.myapp.springredisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save-user")
    public ResponseEntity saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        List<User> users =  userService.getAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

}
