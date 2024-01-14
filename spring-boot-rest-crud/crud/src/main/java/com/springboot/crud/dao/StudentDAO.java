package com.springboot.crud.dao;

import com.springboot.crud.entity.Student;
import java.util.List;

/**
 * The interface representing Data Access Object (DAO) for managing Student entities.
 * This interface defines methods for querying and manipulating Student entities in a database.
 */
public interface StudentDAO {

    /**
     * Retrieves a list of all Student entities stored in the database.
     *
     * @return A list of all Student entities.
     */
    List<Student> findAll();

    /**
     * Retrieves a specific Student entity from the database based on the specified ID.
     *
     * @param theId The unique identifier of the Student entity.
     * @return The found Student entity, or null if not found.
     */
    Student findById(int theId);

    /**
     * Saves a new Student entity in the database.
     *
     * @param theStudent The Student object to be saved.
     * @return The saved Student entity.
     */
    Student save(Student theStudent);

    /**
     * Deletes a specific Student entity from the database based on the specified ID.
     *
     * @param theId The unique identifier of the Student entity to be deleted.
     */
    void deleteById(int theId);
}
