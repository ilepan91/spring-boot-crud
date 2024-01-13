package com.springboot.hibernate;

import com.springboot.hibernate.dao.StudentDAO;
import com.springboot.hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Main application class for CRUD operations on Student entities.
 */
@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	/**
	 * Bean method to run command line tasks related to Student CRUD operations.
	 *
	 * @param studentDAO The Student DAO for database operations.
	 * @return A CommandLineRunner to execute tasks on application startup.
	 */
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createStudent(studentDAO);
			readStudent(studentDAO);
			queryForStudents(studentDAO);
			updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	/**
	 * Method used to create and save a new Student entity.
	 *
	 * @param studentDAO The Student DAO for database operations.
	 */
	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("========== CREATE STUDENT ==========");
		Student newStudent = new Student("Ivana", "Lepan", "ilepan@math.com");

		// save the student object
		System.out.println("========== SAVE STUDENT ==========");
		studentDAO.save(newStudent);

		System.out.println("========== DISPLAY STUDENT ==========");
		System.out.println(studentDAO.findById(newStudent.getId()));

	}

	/**
	 * Method used to read and retrieve a Student entity from the database.
	 *
	 * @param studentDAO The Student DAO for database operations.
	 */
	private void readStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("========== CREATE STUDENT ==========");
		Student newStudent = new Student("Luka", "Kolega", "lkolega@math.com");

		// save the student object
		System.out.println("========== SAVE STUDENT ==========");
		studentDAO.save(newStudent);

		// display id of the saved student
		int theId = newStudent.getId();

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student from the DB with id: " + theId);
		// display student
		System.out.println(studentDAO.findById(theId));
	}

	/**
	 * Method used to query for and list all students from the database.
	 *
	 * @param studentDAO The Student DAO for database operations.
	 */
	private void queryForStudents(StudentDAO studentDAO) {

		System.out.println("Create a few more students in the DB");

		Student newStudent1 = new Student("Vesna", "Babun", "vbabun@math.com");
		Student newStudent2 = new Student("Marija", "Blaslov", "mblslov@math.com");
		Student newStudent3 = new Student("Marko", "Nemet", "mnemet@math.com");

		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);

		System.out.println("========== LIST ALL STUDENTS FROM THE DB ==========");

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

		System.out.println("==========================================================================");
	}

	/**
	 * Method used to update an existing Student entity in the database.
	 *
	 * @param studentDAO The Student DAO for database operations.
	 */
	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Student with id: " + studentId + " " + studentDAO.findById(studentId));
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Ivona"
		System.out.println("========== UPDATE STUDENT ==========");
		myStudent.setFirstName("Ivona");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);

		System.out.println("==========================================================================");
	}

	/**
	 * Method used to delete a Student entity from the database.
	 *
	 * @param studentDAO The Student DAO for database operations.
	 */
	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Student with id: " + studentId + " " + studentDAO.findById(studentId));

		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);

		if(studentDAO.findById(studentId) == null){
			System.out.println("Student with id: " + studentId + " not found in the DB!");
		}
	}
}
