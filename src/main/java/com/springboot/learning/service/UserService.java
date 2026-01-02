package com.springboot.learning.service;

import com.springboot.learning.model.Users;
import com.springboot.learning.repostiory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class UserService implements ApplicationRunner, CommandLineRunner, UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args){
        System.out.println("Application started - Application Runner");
    }

    @Override
    public void run(String... args){
        System.out.println("Application started - Command Line Runner");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(),true, true, true,
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList()
                );

    }
}
