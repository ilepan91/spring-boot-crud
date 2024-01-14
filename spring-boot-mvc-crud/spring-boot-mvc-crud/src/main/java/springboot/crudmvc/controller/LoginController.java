package springboot.crudmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling login-related HTTP requests.
 * Annotated with {@link Controller} to indicate that it is a Spring MVC controller.
 */
@Controller
public class LoginController {

    /**
     * Handles GET requests for "/login" and displays the login page.
     *
     * @return The view name for displaying the login page.
     */
    @GetMapping("/login")
    public String showLoginPage() {

        return "students/login-page";
    }
    /**
     * Handles GET requests for "/access-denied" and displays the access denied page.
     *
     * @return The view name for displaying the access denied page.
     */
    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {

        return "students/access-denied";
    }
}
