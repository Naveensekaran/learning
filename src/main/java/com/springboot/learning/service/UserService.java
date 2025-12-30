package com.springboot.learning.service;

import com.springboot.learning.model.UserDetails;
import com.springboot.learning.repostiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile("dev")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getUserByUserId(String userId){
       Optional<UserDetails> user =  userRepository.findByUserId(userId);
       return user.map(UserDetails::getFirstName).orElse("User not found");
    }
}
