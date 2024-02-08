package com.hexaware.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hexaware.util.EmployeeServiceDb;

/**
 * Test class for the EmployeeServiceDb's employee-related methods.
 */
public class EmployeeTest {

	/**
	 * Test the validation of an invalid employee ID.
	 */
	@Test
	public void testEmployeeId() {

		EmployeeServiceDb esdb = new EmployeeServiceDb();

		int invalidEmployeeId = 9886;
		assertFalse(esdb.isValidEmployee(invalidEmployeeId));
	}
}
