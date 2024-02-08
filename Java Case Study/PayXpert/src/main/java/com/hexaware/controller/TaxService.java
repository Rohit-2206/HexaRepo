/**
 *Controller Package.
 */
package com.hexaware.controller;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.hexaware.dao.ITaxService;
import com.hexaware.exception.TaxCalculationException;
import com.hexaware.util.EmployeeServiceDb;
import com.hexaware.util.TaxServiceDb;

/**
 * TaxService class implements the ITaxService interface.
 * This class provides the implementation for managing tax-related operations.
 */
public class TaxService implements ITaxService {

	Scanner read = new Scanner(System.in);
	TaxServiceDb txdb = new TaxServiceDb();
	EmployeeServiceDb esdb = new EmployeeServiceDb();

	/**
	 * Retrieves and returns details of tax based on the provided tax ID.
	 *
	 * @param taxId The ID of the tax record to be viewed.
	 */
	@Override
	public void getTaxById(int taxId) {
		try {
		System.out.println("Enter the ID of the record to view");
		int id = read.nextInt();
		txdb.taxById(id);
		}catch(InputMismatchException e) {
			System.out.println("Invalid Input");
			read.nextLine();
		}
	}

	/**
	 * Retrieves and returns tax records for a specific employee.
	 *
	 * @param employeeId The ID of the employee for whom tax records are to be viewed.
	 */
	@Override
	public void getTaxesForEmployee(int employeeId) {
		try {
		System.out.println("Enter the Employee ID to view the tax record");
		int empId = read.nextInt();
		txdb.taxByEmployeeId(empId);
		}catch(InputMismatchException e) {
			System.out.println("Invalid Input");
			read.nextLine();
		}
	}

	/**
	 * Retrieves and returns tax records for a specified tax year.
	 *
	 * @param taxYear The tax year for which tax records are to be viewed.
	 * @return Tax records for the specified tax year.
	 */
	@Override
	public int getTaxesForYear(int taxYear) {

		System.out.println("Enter the year to view the tax record");
		taxYear = read.nextInt();
		if(!txdb.taxByYear(taxYear).equals("")) 
		{
			System.out.println(txdb.taxByYear(taxYear));
		}
		else
		{
			System.out.println("No tax records available for the year "+taxYear);
		}
		return taxYear;
	}
	
	/**
	 * Calculates tax for an employee in a specified tax year.
	 *
	 * @param employeeId The ID of the employee for whom tax is to be calculated.
	 * @param year The tax year for which tax is to be calculated.
	 * @return A message representing the calculated tax amount.
	 */
	
	@Override
	public double taxCalculator(int employeeId, int year) {
	    System.out.println("Enter the employee ID");
	    employeeId = read.nextInt();

	    if (esdb.isValidEmployee(employeeId)) {
	        System.out.println("Enter the year to calculate tax");
	        year = read.nextInt();

	        try {
	            double paidAmount = txdb.calculateTax(employeeId, year);

	            if (paidAmount == 0.0) {
	                throw new TaxCalculationException();
	            } else if (paidAmount < 250000) {
	                return 0.0;
	            } else if (paidAmount <= 500000) {
	                return (paidAmount - 250000) * 0.05; 
	            } else if (paidAmount <= 750000) {
	                return (paidAmount - 500000) * 0.10; 
	            } else if (paidAmount <= 1000000) {
	                return (paidAmount - 750000) * 0.20; 
	            } else {
	                return (paidAmount - 1000000) * 0.30; 
	            }
	        } catch (TaxCalculationException e) {
	            System.out.println(e.getMessage());
	            return 0.0; 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return 0.0; 
	        }
	    } else {
	        System.out.println("Invalid Employee ID");
	        return 0.0; 
	    }
	}
}
