package springboot.crudmvc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Entity class representing a student.
 * This class is annotated with {@link Entity} to indicate that it is a JPA entity,
 * and it is mapped to the "student" table in the database using {@link Table} annotation.
 */
@Entity
@Table(name="student")
public class Student {

    /**
     * The unique identifier for the student.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /**
     * The first name of the student.
     */
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    @Column(name="first_name")
    private String firstName;

    /**
     * The last name of the student.
     */
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    @Column(name="last_name")
    private String lastName;

    /**
     * The email address of the student.
     */
    @Column(name="email")
    private String email;

    /**
     * The study programme of the student.
     */
    @Column(name="study_programme")
    private String studyProgramme;

    /**
     * Default constructor for the Student class.
     */
    public Student() {

    }

    /**
     * Constructs a new Student object with the specified details.
     *
     * @param firstName      The first name of the student.
     * @param lastName       The last name of the student.
     * @param email          The email address of the student.
     * @param studyProgramme The study programme of the student.
     */
    public Student(String firstName, String lastName, String email, String studyProgramme) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studyProgramme = studyProgramme;
    }

    /**
     * Gets the unique identifier of the student.
     *
     * @return The student's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the student.
     *
     * @param id The new student ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name of the student.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     *  @param firstName The first name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     *  @param lastName The last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the student's email address
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email address.
     *
     *  @param email The email address of the student.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the study programme of the student.
     *
     * @return The study programme of the student.
     */
    public String getStudyProgramme() {
        return studyProgramme;
    }

    /**
     * Sets the study programme of the student.
     *
     * @param studyProgramme The new study programme to be set.
     */
    public void setStudyProgramme(String studyProgramme) {
        this.studyProgramme = studyProgramme;
    }

    /**
     * Returns a string representation of the Student object.
     *
     * @return A string containing the student's id, first name, last name, email, and study programme.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studyProgramme='" + studyProgramme + '\'' +
                '}';
    }
}








