package com.hexaware.exception;

public class PatientNumberNotFoundException extends Exception{

	public PatientNumberNotFoundException() {
		super("Patiemt Number Not Found!!!");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PatientNumberNotFoundException []";
	}
	
	

}
