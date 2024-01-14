package com.springboot.crud.dao;

import com.springboot.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of the {@link StudentDAO} interface that provides
 * data access operations for managing Student entities using JPA.
 * This class is annotated with {@link Repository} to indicate its role
 * as a Spring Data Repository, and it is responsible for interacting with the
 * EntityManager to perform CRUD operations on the database.
 */
@Repository
public class StudentDAOImpl implements  StudentDAO {

    /**
     * The JPA EntityManager for interacting with the underlying database.
     */
    private EntityManager entityManager;


    /**
     * Constructor for creating a new instance of StudentDAOImpl.
     *
     * @param theEntityManager The JPA EntityManager injected by Spring.
     */
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Student> findAll() {

        // create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);

        // execute query and get result list
        List<Student> students = theQuery.getResultList();

        // return the results
        return students;
    }

    @Override
    public Student findById(int theId) {

        // get student
        Student theStudent = entityManager.find(Student.class, theId);

        return theStudent;
    }

    @Override
    public Student save(Student theStudent) {

        // save student
        Student dbStudent = entityManager.merge(theStudent);

        return dbStudent;
    }

    @Override
    public void deleteById(int theId) {

        // find student by id
        Student theStudent = entityManager.find(Student.class, theId);

        entityManager.remove(theStudent);
    }
 }

