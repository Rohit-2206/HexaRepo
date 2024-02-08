package com.hexaware.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.hexaware.util.PayrollServiceDb;

/**
 * Test class for the PayrollServiceDb's salary calculation methods.
 */
public class PayrollTest {
	PayrollServiceDb psdb = new PayrollServiceDb();
	// result[0][0]+result[0][1] - Gross Salary Test
	// result[0][0]+result[0][1]-result[0][2] - Net Salary Test

    /**
     * Test the calculation of gross salary details.
     */
	@Test
	public void testGrossSalary() {

		double[] result = psdb.grossSalaryDetails();

		double[] grossExpected = { result[0], result[1], result[2], 32800.00 };
		assertArrayEquals(grossExpected, result, 0.0);
	}

	/**
	 * Test the calculation of net salary details.
	 */
	@Test
	public void testNetSalary() {
		double[] result = psdb.netSalaryDetails();
		double[] netExpected = { result[0], result[1], result[2], result[0] + result[1] - result[2] };

		assertArrayEquals(netExpected, result, 0.0);
	}
}
