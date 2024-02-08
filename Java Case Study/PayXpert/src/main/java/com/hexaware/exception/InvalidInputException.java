/*
 *Exception Package. 
 */
package com.hexaware.exception;

/**
 * Exception thrown when an invalid input is encountered.
 */
public class InvalidInputException extends Exception {

    /**
     * Default constructor for the InvalidInputException.
     * Creates an instance without a specific message.
     */
    public InvalidInputException() {
        super();
    }

    /**
     * Returns a string representation of the InvalidInputException.
     *
     * @return A string representation of the InvalidInputException.
     */
    @Override
    public String toString() {
        return "InvalidInputException []";
    }
}

