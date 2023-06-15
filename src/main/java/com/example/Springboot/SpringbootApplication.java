package com.example.Springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	// RUN application with MAVEN === ./mvnw spring-boot:run

	// click RUN for ONLY the main function
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
