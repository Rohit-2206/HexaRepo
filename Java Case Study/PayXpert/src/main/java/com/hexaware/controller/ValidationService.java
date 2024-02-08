/**
 * Controller Package.
 */
package com.hexaware.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.google.protobuf.TextFormat.ParseException;

/**
 * Validation Service to check if the data being entered is valid or not.
 */

public class ValidationService {
	
	/**
	 * Validates the format of a date string. The expected format is "yyyy-mm-dd".
	 *
	 * @param date The date string to be validated.
	 * @return true if the date string is in the correct format, false otherwise.
	 */
	public boolean isValidDate(String date) {
	    return Pattern.matches("\\d{4}-\\d{2}-\\d{2}", date);
	}
	
	/**
	 * Validates the format of an email address string.
	 *
	 * @param email The email address string to be validated.
	 * @return true if the email address string is in the correct format, false  otherwise.
	 */
	public boolean isValidEmail(String email) {
	    return Pattern.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", email);
	}
	
	/**
	 * Validates if the length of the phone number being entered is exactly 10 digits.
	 * @param phoneNumber - The phone number that needs to be validated.
	 * @return true if the phone number is 10 digits else false.
	 */
	public boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.length() == 10;
	}
	
	/**
	 * Validates whether the end date is after the start date or not.
	 * @param startDate - Starting date of the process.
	 * @param endDate - Ending date of the process.
	 * @return True is the end date id after the start , false if not.
	 * @throws java.text.ParseException If there is an error during date parsing.
	 * @throws ParseException If there is an error during date parsing.
	 */
	
    public boolean isEndDateAfterStartDate(String startDate, String endDate) throws java.text.ParseException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateFormat.parse(startDate);
		Date end = dateFormat.parse(endDate);
		return end.after(start);
    }
}

