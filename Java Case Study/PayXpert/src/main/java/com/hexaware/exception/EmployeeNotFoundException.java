/*
 *Exception Package. 
 */
package com.hexaware.exception;

/**
 * Exception thrown when an employee with a specific ID is not found.
 */
public class EmployeeNotFoundException extends Exception {

    /**
     * Default constructor for the EmployeeNotFoundException.
     * Displays a message indicating that the employee ID is not found.
     */
    public EmployeeNotFoundException() {
        super("Employee ID not found");
    }

    /**
     * Returns a string representation of the EmployeeNotFoundException.
     *
     * @return A string representation of the EmployeeNotFoundException.
     */
    @Override
    public String toString() {
        return "EmployeeNotFoundException []";
    }
}
