/*
 *Exception Package. 
 */
package com.hexaware.exception;

/**
 * Exception thrown when a database connection cannot be established due to credential issues.
 */
public class DatabaseConnectionException extends Exception {

    /**
     * Constructs a with the specified detail message.
     */
	public DatabaseConnectionException() {
		super("Connection Cannot be Established check credentials");
		// TODO Auto-generated constructor stub
	}

    /**
     * Returns a string representation of this exception.
     * @return The message.
     */
	@Override
	public String toString() {
		return "DatabaseConnectionException []";
	}

}
