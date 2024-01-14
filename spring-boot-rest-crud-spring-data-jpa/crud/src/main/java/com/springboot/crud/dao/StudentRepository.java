package com.springboot.crud.dao;

import com.springboot.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Student} entities.
 * This interface extends the Spring Data JPA {@link JpaRepository},
 * providing CRUD (Create, Read, Update, Delete) operations for Student entities
 * with the primary key of type {@code Integer}.
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
