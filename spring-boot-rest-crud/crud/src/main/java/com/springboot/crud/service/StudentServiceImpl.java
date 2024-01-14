package com.springboot.crud.service;

import com.springboot.crud.dao.StudentDAO;
import com.springboot.crud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of the {@link StudentService} interface.
 * Provides business logic and interacts with the {@link StudentDAO} to manage Student entities.
 */
@Service
public class StudentServiceImpl implements StudentService {

    /**
     * Data Access Object (DAO) dependency for managing Student entities.
     */
    private StudentDAO studentDAO;

    /**
     * Constructor for creating a new instance of StudentServiceImpl.
     *
     * @param theStudentDAO The StudentDAO dependency injected by Spring.
     */
    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO) {
        studentDAO = theStudentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int theId) {
        return studentDAO.findById(theId);
    }

    @Transactional
    @Override
    public Student save(Student theStudent) {
        return studentDAO.save(theStudent);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        studentDAO.deleteById(theId);
    }

}
