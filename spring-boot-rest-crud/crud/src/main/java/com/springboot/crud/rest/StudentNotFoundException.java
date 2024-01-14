package com.springboot.crud.rest;

/**
 * Custom exception class representing a scenario where a Student entity is not found.
 * This exception extends the {@link RuntimeException}, making it an unchecked exception.
 */
public class StudentNotFoundException extends RuntimeException {

    /**
     * Constructs a new instance of StudentNotFoundException with the specified error message.
     *
     * @param message The detail message indicating the reason for the exception.
     */
    public StudentNotFoundException(String message) {
        super(message);
    }
}
