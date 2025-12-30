package com.springboot.learning;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("Bean instantiated");
	}

	@PreDestroy
	public void preDestroy(){
		System.out.println("Bean destroyed");

	}

}
