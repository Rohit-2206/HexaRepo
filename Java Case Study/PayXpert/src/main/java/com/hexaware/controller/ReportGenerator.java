/**
 *Controller Package.
 */
package com.hexaware.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.hexaware.util.EmployeeServiceDb;
import com.hexaware.util.ReportGeneratorDb;

/**
 * ReportGenerator class responsible for generating various reports based on financial and payroll data.
 * It includes methods for generating reports such as total salary paid, tax details, and employee-wise details.
 */
public class ReportGenerator {
	EmployeeServiceDb esdb = new EmployeeServiceDb();
	static Scanner read = new Scanner(System.in);
	ReportGeneratorDb rgdb = new ReportGeneratorDb();

	/**
	 * Retrieves and returns details of salary paid by year.
	 *
	 * @return Details of salary paid for the specified year.
	 */
	public String salaryPaidByYear() {
		System.out.println("Enter the year to view details");
		int year = read.nextInt();
		String details = rgdb.salaryPaidByYear(year);
		return details;
	}

	/**
	 * Displays details of salary paid by month for the specified year.
	 */
	public void salaryPaidByMonth() {
		System.out.println("Enter the year to view details");
		int year = read.nextInt();
		System.out.println(rgdb.salaryPaidByMonth(year));
	}

	/**
	 * Displays details of salary paid for a specific employee.
	 */
	public void salaryPaidByEmployee() {
		try {
		System.out.println("Enter the id to view details");
		int employeeId = read.nextInt();
		if(esdb.isValidEmployee(employeeId)) {
		System.out.println(rgdb.salaryPaidByEmployee(employeeId));
		}
		else {
			System.out.println("Invalid Employee ID");
		}
		}catch(InputMismatchException e) {
			System.out.println("Invalid Input");
		}
	}
}
