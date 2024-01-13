package com.springboot.hibernate.dao;

import com.springboot.hibernate.entity.Student;
import java.util.List;

/**
 * The interface representing Data Access Object (DAO) for managing Student entities.
 * This interface defines methods for CRUD (Create, Read, Update, Delete) operations
 * related to the Student entity in a database.
 */
public interface StudentDAO {

    /**
     * Saves a new Student entity in the database.
     *
     * @param theStudent The Student object to be saved.
     */
    void save(Student theStudent);

    /**
     * Retrieves a Student entity from the database based on the specified ID.
     *
     * @param id The unique identifier of the Student entity.
     * @return The found Student entity, or null if not found.
     */
    Student findById(Integer id);

    /**
     * Retrieves a list of all Student entities stored in the database.
     *
     * @return A list of all Student entities.
     */
    List<Student> findAll();

    /**
     * Updates an existing Student entity in the database.
     *
     * @param theStudent The Student object with updated information.
     */
    void update(Student theStudent);

    /**
     * Deletes a Student entity from the database based on the specified ID.
     *
     * @param id The unique identifier of the Student entity to be deleted.
     */
    void delete(Integer id);
}
