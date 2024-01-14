package com.springboot.crud.rest;

import com.springboot.crud.entity.Student;
import com.springboot.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for handling CRUD operations related to Student entities.
 * Exposes endpoints for retrieving, adding, updating, and deleting students.
 */
@RestController
@RequestMapping("/api")
public class StudentRestController {

    /**
     * Service layer dependency for managing Student entities.
     */
    private StudentService studentService;

    /**
     * Constructor for creating a new instance of StudentRestController.
     *
     * @param theStudentService The StudentService dependency injected by Spring.
     */
    @Autowired
    public StudentRestController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    /**
     * Retrieves a list of all students.
     *
     * @return A list of all Student entities.
     */
    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    /**
     * Retrieves a specific student based on the provided studentId.
     *
     * @param studentId The unique identifier of the student.
     * @return The found Student entity.
     * @throws RuntimeException if the student with the specified id is not found.
     */
    @GetMapping("/students/{studentId}")
    public Optional<Student> getStudent(@PathVariable int studentId) {

        Optional<Student> theStudent = studentService.findById(studentId);

        if(!theStudent.isPresent()) {
            throw new RuntimeException("The student with id " + studentId + " not found!");
        }

        return theStudent;
    }

    /**
     * Adds a new student to the database.
     *
     * @param theStudent The Student object to be added.
     * @return The added Student entity.
     */
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent) {

        // if user passes an id in json, id should be set to 0, to force a 'save' of a new student (instead of update)
        theStudent.setId(0);

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    /**
     * Updates an existing student in the database.
     *
     * @param theStudent The updated Student object.
     * @return The updated Student entity.
     */
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent) {

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    /**
     * Deletes a specific student based on the provided studentId.
     *
     * @param studentId The unique identifier of the student to be deleted.
     * @return A confirmation message indicating the deleted student's id.
     * @throws RuntimeException if the student with the specified id is not found.
     */
    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        Optional<Student> tempStudent = studentService.findById(studentId);

        if(!tempStudent.isPresent()) {
            throw new RuntimeException("The student with id " + studentId + " not found!");
        }

        studentService.deleteById(studentId);

        return "Student with the id " + studentId + " is deleted!";
    }
}