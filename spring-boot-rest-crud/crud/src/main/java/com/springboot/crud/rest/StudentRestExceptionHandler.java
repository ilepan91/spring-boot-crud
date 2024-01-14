package com.springboot.crud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling exceptions related to Student entities in RESTful endpoints.
 * It uses the {@link ControllerAdvice} annotation to provide centralized exception handling for all
 * controllers in the application.
 */
@ControllerAdvice
public class StudentRestExceptionHandler {

    /**
     * Handles exceptions of type {@link StudentNotFoundException}.
     *
     * @param exc The exception of type {@link StudentNotFoundException}.
     * @return A {@link ResponseEntity} containing the error response for the specified exception.
     */
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        // Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // Return ResponseEntity with error response and HTTP status NOT_FOUND
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}



