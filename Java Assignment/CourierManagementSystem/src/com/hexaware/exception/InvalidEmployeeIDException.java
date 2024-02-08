package com.hexaware.exception;

public class InvalidEmployeeIDException extends Exception {

	// Task 7 Invalid EmployeeID Exception

	public InvalidEmployeeIDException() {
		super("Invalid EmployeeID");
		// TODO Auto-generated constructor stub
	}

	public InvalidEmployeeIDException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InvalidEmployeeIDException []";
	}

}
