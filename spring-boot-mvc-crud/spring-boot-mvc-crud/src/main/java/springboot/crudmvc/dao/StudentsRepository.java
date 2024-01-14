package springboot.crudmvc.dao;

import springboot.crudmvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing Student entities using Spring Data JPA.
 * Extends {@link JpaRepository} with Student as the entity type and Integer as the primary key type.
 */
public interface StudentsRepository extends JpaRepository<Student, Integer> {

    /**
     * Retrieves a list of all Student entities, sorted by last name in ascending order.
     *
     * @return A list of all Student entities, sorted by last name in ascending order.
     */
    public List<Student> findAllByOrderByLastNameAsc();

}
