package springboot.crudmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Spring Boot application managing students.
 * Annotated with {@link SpringBootApplication}, indicating that it is
 * the entry point for the Spring Boot application and enabling
 * auto-configuration and component scanning.
 */
@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		SpringApplication. run(StudentsApplication.class, args);
	}

}
