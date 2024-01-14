package springboot.crudmvc.service;

import springboot.crudmvc.dao.StudentsRepository;
import springboot.crudmvc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentsRepository studentsRepository;

    @Autowired
    public StudentServiceImpl(StudentsRepository theStudentRepository) {

        studentsRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {

        return studentsRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentsRepository.findById(theId);

        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find student id - " + theId);
        }

        return theStudent;
    }

    @Override
    public Student save(Student theStudent) {

        return studentsRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {

        studentsRepository.deleteById(theId);
    }
}






