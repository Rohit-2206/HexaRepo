/**
 *Controller Package. 
 */
package com.hexaware.controller;

import java.util.InputMismatchException;

import java.util.Scanner;

import com.google.protobuf.TextFormat.ParseException;
import com.hexaware.dao.IPayrollService;
import com.hexaware.entity.Payroll;
import com.hexaware.util.EmployeeServiceDb;
import com.hexaware.util.PayrollServiceDb;

/**
 * PayrollService class implements the IPayrollService interface and provides functionalities related to payroll processing.
 * It includes methods for calculating gross and net salary, generating payslips, and handling payroll exceptions.
 */
public class PayrollService implements IPayrollService {
	Payroll pr;
	PayrollServiceDb psdb = new PayrollServiceDb();
	ValidationService vs = new ValidationService();
	EmployeeServiceDb esdb = new EmployeeServiceDb();
	Scanner read = new Scanner(System.in);

	/**
	 * Generates a payroll entry for an employee within a specified pay period.
	 *
	 * @param employeeId The ID of the employee for whom the payroll is generated.
	 * @param startDate The start date of the pay period.
	 * @param endDate The end date of the pay period.
	 * @throws java.text.ParseException If an error occurs during parsing.
	 * @throws ParseException If an error occurs during parsing.
	 */
	@Override
	public void generatePayroll(int employeeId, String startDate, String endDate) throws ParseException, java.text.ParseException {
		try {
		pr = new Payroll();
		System.out.println("Enter the EmployeeID");
		employeeId = read.nextInt();
		pr.setEmployeeId(employeeId);
		
		if(esdb.isValidEmployee(employeeId)) {
		if(psdb.isNotTerminated(employeeId).equals("NotTerminated")) {
			
		System.out.println("Enter Pay Period Start Date");
		startDate = read.next();
		while (!vs.isValidDate(startDate)) {
		    System.out.println("Invalid Date format. \nPlease enter in yyyy-mm-dd format.");
		    startDate = read.next();
		}
		pr.setPayPeriodStartDate(startDate);

		System.out.println("Enter Pay Period End date");
		endDate = read.next();
		while (!vs.isValidDate(endDate) || !vs.isEndDateAfterStartDate(startDate, endDate)) {
            if (!vs.isValidDate(endDate)) {
                System.out.println("Invalid Date format. \nPlease enter in yyyy-mm-dd format.");
            } else {
                System.out.println("End date must be after the start date. Please enter again.");
            }
            endDate = read.next();
		}
		pr.setPayPeriodEndDate(endDate);

		System.out.println("Enter the Basic Salary Amount");
		double basic = read.nextDouble();
		pr.setBasicSalary(basic);

		System.out.println("Enter the OverTime Pay Amount");
		double overTime = read.nextDouble();
		pr.setOverTimePay(overTime);

		System.out.println("Enter the Deductions Amount");
		double deductions = read.nextDouble();
		pr.setDeductions(deductions);

		psdb.payrollGeneration(pr);
		}
		else
		{
			System.out.println("Employee is terminated");
		}
		}else {
			System.out.println("Invalid Employee ID");
		}
		}catch (InputMismatchException e) {
			System.out.println("Invalid Input!!!");
			read.nextLine();
		}
	}

	/**
	 * Retrieves and displays the payroll information based on the provided payroll ID.
	 *
	 * @param payrollId The ID of the payroll to be searched.
	 */
	@Override
	public void getPayrollById(int payrollId) {
		try {
		System.out.println("Enter the payroll ID you want to search");
		int id = read.nextInt();
		System.out.println(psdb.payrollById(id));
		}catch(InputMismatchException e) {
			System.out.println("Invalid Input");
			read.nextLine();
		}
	}

	/**
	 * Retrieves and displays the payrolls associated with a specific employee.
	 *
	 * @param employeeId The ID of the employee for whom payrolls are to be retrieved.
	 */
	@Override
	public void getPayrollsForEmployee(int employeeId) {
		try {
		System.out.println("Enter the employee ID");
	    employeeId = read.nextInt();
		if(esdb.isValidEmployee(employeeId)) {
		System.out.println(psdb.payrollByEmployeeId(employeeId));
		}
		else
		{
			System.out.println("Invalid Employee ID");
		}
		}catch(InputMismatchException e) {
			System.out.println("Invalid Input");
			read.nextLine();
		}
	}

	/**
	 * Retrieves and displays payrolls within a specified pay period.
	 *
	 * @param startDate The start date of the pay period.
	 * @param endDate The end date of the pay period.
	 * @return A message indicating the success or failure of retrieving payrolls for the specified period.
	 */
	@Override
	public String getPayrollsForPeriod(String startDate, String endDate) {

		System.out.println("Enter the Pay Period Start Date ");
		startDate = read.next();
		while (!vs.isValidDate(startDate)) {
		    System.out.println("Invalid Date format. \nPlease enter in yyyy-mm-dd format.");
		    startDate = read.next();
		}
		System.out.println("Enter the Pay Period End Date");
		endDate = read.next();
		while (!vs.isValidDate(endDate)) {
		    System.out.println("Invalid Date format. \nPlease enter in yyyy-mm-dd format.");
		    endDate = read.next();
		}
		if(!psdb.getPayrollsForPeriod(startDate, endDate).equals("")) {
		System.out.println(psdb.getPayrollsForPeriod(startDate, endDate));
		}
		else 
		{
			System.out.println("No records found between "+startDate+ " and " +endDate);
		}
		return "";
	}

}
