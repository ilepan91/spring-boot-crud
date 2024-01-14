package com.springboot.crud.service;

import com.springboot.crud.entity.Student;

import java.util.List;

/**
 * Service interface for managing Student entities.
 * Defines methods for retrieving, saving, updating, and deleting Student entities.
 */
public interface StudentService {

    /**
     * Retrieves a list of all Student entities.
     *
     * @return A list of all Student entities.
     */
    List<Student> findAll();

    /**
     * Retrieves a specific Student entity based on the provided id.
     *
     * @param theId The unique identifier of the Student entity.
     * @return The found Student entity, or null if not found.
     */
    Student findById(int theId);

    /**
     * Saves a new or existing Student entity.
     *
     * @param theStudent The Student object to be saved.
     * @return The saved Student entity.
     */
    Student save(Student theStudent);

    /**
     * Deletes a specific Student entity based on the provided id.
     *
     * @param theId The unique identifier of the Student entity to be deleted.
     */
    void deleteById(int theId);
}

