package com.springboot.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Spring Boot RESTful CRUD application.
 * This class is annotated with {@link SpringBootApplication}, indicating that it is the entry point
 * for the Spring Boot application and enabling auto-configuration and component scanning.
 */
@SpringBootApplication
public class RestCrudApplication {

	/**
	 * The main method to start the Spring Boot application.
	 *
	 * @param args The command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestCrudApplication.class, args);
	}

}
