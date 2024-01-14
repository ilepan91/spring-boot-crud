package com.springboot.crud.rest;

/**
 * Represents an error response for handling exceptions in the Student REST API.
 * It includes information such as the HTTP status code, an error message, and a timestamp.
 */
public class StudentErrorResponse {

    /**
     * The HTTP status code indicating the error.
     */
    private int status;

    /**
     * The error message providing details about the issue.
     */
    private String message;

    /**
     * The timestamp when the error occurred.
     */
    private long timeStamp;

    /**
     * Default constructor for creating a new instance of StudentErrorResponse.
     */
    public StudentErrorResponse() {
        // Default constructor
    }

    /**
     * Constructor for creating a new instance of StudentErrorResponse with specified details.
     *
     * @param status    The HTTP status code indicating the error.
     * @param message   The error message providing details about the issue.
     * @param timeStamp The timestamp when the error occurred.
     */
    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    /**
     * Gets the HTTP status code indicating the error.
     *
     * @return The HTTP status code.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the HTTP status code indicating the error.
     *
     * @param status The HTTP status code.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the error message providing details about the issue.
     *
     * @return The error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the error message providing details about the issue.
     *
     * @param message The error message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the timestamp when the error occurred.
     *
     * @return The timestamp.
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the timestamp when the error occurred.
     *
     * @param timeStamp The timestamp.
     */
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Returns a string representation of the StudentErrorResponse object.
     *
     * @return A string containing the status code, error message, and timestamp.
     */
    @Override
    public String toString() {
        return "StudentErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}