package com.springboot.crud.service;

import com.springboot.crud.dao.StudentRepository;
import com.springboot.crud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * This class provides the implementation of the {@link StudentService} interface.
 * It manages Student entities by interacting with the data layer through the {@link StudentRepository}.
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

    /**
     * The repository for interacting with student data.
     */
    private StudentRepository studentRepository;

    /**
     * Constructor for creating a new instance of StudentServiceImpl.
     *
     * @param theStudentRepository The studentRepository dependency injected by Spring
     */
    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository) {
        studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(int theId) {
        return studentRepository.findById(theId);
    }

    @Override
    public Student save(Student theEmployee) {
        return studentRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }

}
