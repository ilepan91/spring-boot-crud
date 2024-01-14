package springboot.crudmvc.controller;


import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import springboot.crudmvc.entity.Student;
import springboot.crudmvc.service.StudentService;

import java.util.List;

/**
 * Controller class for handling HTTP requests related to Student entities.
 * Annotated with {@link Controller} to indicate that it is a Spring MVC controller.
 * Handles requests under the "/students" path.
 */
@Controller
@RequestMapping("/students")
public class StudentController {

    /**
     * Service layer dependency for managing Student entities.
     */
    private StudentService studentService;

    /**
     * Constructor for creating a new instance of StudentController.
     *
     * @param theStudentService The StudentService dependency injected by Spring.
     */
    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    /**
     * Initializes a WebDataBinder to trim input strings by removing leading and trailing whitespace.
     *
     * @param dataBinder The WebDataBinder instance to be initialized.
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    /**
     * Handles GET requests for "/students/list" and retrieves a list of all students.
     *
     * @param theModel The Model used to pass data to the view.
     * @return The view name for displaying the list of students.
     */
    @GetMapping("/list")
    public String listStudents(Model theModel) {

        List<Student> theStudents = studentService.findAll();

        theModel.addAttribute("students", theStudents);

        return "students/list-students";
    }

    /**
     * Handles GET requests for "/students/showAddForm" and shows the form for adding a new student.
     *
     * @param theModel The Model used to pass data to the view.
     * @return The view name for displaying the student form.
     */
    @GetMapping("/showAddForm")
    public String showAddForm(Model theModel) {

        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "students/student-form";
    }

    /**
     * Handles GET requests for "/students/showUpdateForm" and shows the form for updating a student.
     *
     * @param theId The ID of the student to be updated.
     * @param theModel The Model used to pass data to the view.
     * @return The view name for displaying the student form.
     */
    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("studentId") int theId,
                                    Model theModel) {

        Student theStudent = studentService.findById(theId);

        theModel.addAttribute("student", theStudent);

        return "students/student-form";
    }

    /**
     * Handles POST requests for "/students/save" to save or update a student.
     *
     * @param theStudent The Student object to be saved or updated.
     * @param theBindingResult The BindingResult for validating the form data.
     * @return The view name or redirect URL based on the result of the form submission.
     */
    @PostMapping("/save")
    public String saveStudent(@Valid@ModelAttribute("student") Student theStudent, BindingResult theBindingResult) {

        if (theBindingResult.hasErrors()) {
            return "students/student-form";
        }
        else {
            //save the student
            studentService.save(theStudent);

            //use a redirect to prevent duplicate submissions
            return "redirect:/students/list";
        }
    }

    /**
     * Handles GET requests for "/students/delete" to delete a student.
     *
     * @param theId The ID of the student to be deleted.
     * @return The redirect URL to the list of students.
     */
    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId) {

        studentService.deleteById(theId);

        // redirect to /students/list
        return "redirect:/students/list";
    }

    /**
     * Handles GET requests for "/students/showUserRole" to display user roles.
     *
     * @return The view name for displaying user roles.
     */
    @GetMapping("/showUserRole")
    public String showUserRole() {

        return "/students/user-role";
    }
}
