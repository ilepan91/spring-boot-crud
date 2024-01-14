package springboot.crudmvc.service;

import springboot.crudmvc.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theEmployee);

    void deleteById(int theId);

}
