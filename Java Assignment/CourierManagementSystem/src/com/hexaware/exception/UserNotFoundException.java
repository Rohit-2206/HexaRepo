package com.hexaware.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("User Not Found");
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserNotFoundException []";
	}
}
