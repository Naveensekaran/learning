package com.springboot.learning.controller;

import com.springboot.learning.model.Users;
import com.springboot.learning.repostiory.UserRepository;
import com.springboot.learning.security.JwtService;
import com.springboot.learning.service.UserService;
import com.springboot.learning.validation.Create;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> body){
        String userName = body.get("username");
        String password = body.get("password");

        if(userRepository.findByUsername(userName).isPresent()){
//            new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        else{
            userService.createUser(Users.builder().username(userName).password(passwordEncoder.encode(password)).build());
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Validated(Create.class) @RequestBody Users body){
//        String userName = body.get("username");
//        String password = body.get("password");

        String userName = body.getUsername();
        String password = body.getPassword();

        Optional<Users> userOptional = userRepository.findByUsername(userName);

        if(userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not registered");
        }
        Users user = userOptional.get();

        if(!passwordEncoder.matches(password, user.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid User");
        }
        String token = jwtService.generateToken(userName);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("token", token));
    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable long id) throws Exception {
        return userService.getUserById(id);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRunTime(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
