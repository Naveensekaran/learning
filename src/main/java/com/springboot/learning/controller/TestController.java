package com.springboot.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/public/hello")
    public String publicApi() {
        return "Public access";
    }

    @GetMapping("/user/hello")
    public String userApi() {
        return "User access";
    }

    @GetMapping("/admin/hello")
    public String adminApi() {
        return "Admin access";
    }
}