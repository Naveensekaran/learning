package com.springboot.learning.service;


import com.springboot.learning.model.Users;
import com.springboot.learning.repostiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//@Profile("dev")
public class UserService implements ApplicationRunner, CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public void createUser(Users user){
        userRepository.save(user);
    }

    public Users getUser(long id) throws Exception{
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
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
