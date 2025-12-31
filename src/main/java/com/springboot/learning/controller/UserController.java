package com.springboot.learning.controller;

import com.springboot.learning.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable("id") String userid){
        String result =  userService.getUserByUserId(userid);
        return result;
    }

}
