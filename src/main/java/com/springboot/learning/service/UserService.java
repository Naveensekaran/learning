package com.springboot.learning.service;


import com.springboot.learning.model.Users;
import com.springboot.learning.repostiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
//@Profile("dev")
public class UserService implements ApplicationRunner, CommandLineRunner {
//public class UserService{
    @Autowired
    private UserRepository userRepository;

    public void createUser(Users user){
        userRepository.save(user);
    }

    @Cacheable(value = "users", key = "#userId")
    public Users getUserById(long id) throws Exception{
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
    }

    @CachePut(value = "users", key = "#user.id")
    public Users UpdateUserById(long id){
        return userRepository.save(new Users());
    }

    @CacheEvict(value = "users", key ="#user.id")
    public void deleteUserById(long id){
        userRepository.deleteById(id);
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
