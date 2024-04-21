package com.hexaware.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.hexaware.controller.TaxService;
import com.hexaware.entity.Tax;

/**
 * Test class for the TaxService's taxCalculator method.
 */
public class TaxTest {
	
	/**
     * Test the taxCalculator method of the TaxService class.
     *
     * @throws SQLException If a database access error occurs.
     */
	@Test
	public void testTaxCalculator() throws SQLException {
		
		TaxService tx = new TaxService();
		Tax t = new Tax();
		double calculatedTax = tx.taxCalculatorForTest(t.getEmployeeId(), t.getTaxYear());
	    double expectedTax = 6740.0;

	    assertEquals(expectedTax, calculatedTax, 0.01);
		
	}
}
