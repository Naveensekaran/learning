package com.springboot.learning.service;

import com.springboot.learning.model.UserDetails;
import com.springboot.learning.repostiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile("dev")
public class UserService implements ApplicationRunner, CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public String getUserByUserId(String userId){
       Optional<UserDetails> user =  userRepository.findByUserId(userId);
       return user.map(UserDetails::getFirstName).orElse("User not found");
    }

    @Override
    public void run(ApplicationArguments args){
        System.out.println("Application started - Application Runner");
    }

    @Override
    public void run(String... args){
        System.out.println("Application started - Command Line Runner");
    }
}
