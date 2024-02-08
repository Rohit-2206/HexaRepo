package com.hexaware.exception;

public class TrackingNumberNotFoundException extends Exception {

	// Task 7 Tracking Number Not Found Exception

	public TrackingNumberNotFoundException() {
		super("Tracking Number Not Found");
		// TODO Auto-generated constructor stub
	}

	public TrackingNumberNotFoundException(String message) {
		super("Tracking Number not Found");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TrackingNumberNotFoundException []";
	}

	
}
