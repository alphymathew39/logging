package com.example.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // Enable AspectJ AOP support
public class LoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingApplication.class, args);
	}

}
