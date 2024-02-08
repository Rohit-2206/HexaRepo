/**
 *Util Package. 
 */
package com.hexaware.util;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import com.hexaware.entity.Payroll;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.PayrollGenerationException;

/**
 * PayrollServiceDb class handles the interaction with the database for payroll-related operations.
 * It includes methods for retrieving, updating, and generating payroll information.
 */
public class PayrollServiceDb{

	Connection connection;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	EmployeeServiceDb esdb = new EmployeeServiceDb();

	/**
	 * Establishing connection with database. 
	 */
	public PayrollServiceDb() {
		connection = DBConnectionUtil.getConnection();
	}
	/**
	 * Generates a payroll record for an employee and inserts it into the Payroll table.
	 * 
	 * @param pr The Payroll object containing details of the payroll record.
	 * @return The number of rows affected , 1 if the insertion is successful.
	 */
	public int payrollGeneration(Payroll pr){
		try {
			ps = connection.prepareStatement(
					"INSERT INTO Payroll (EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary,OvertimePay, Deductions) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, pr.getEmployeeId());
			ps.setString(2, pr.getPayPeriodStartDate());
			ps.setString(3, pr.getPayPeriodEndDate());
			ps.setDouble(4, pr.getBasicSalary());
			ps.setDouble(5, pr.getOverTimePay());
			ps.setDouble(6, pr.getDeductions());
			
			int noofrows = ps.executeUpdate();
			if(noofrows > 0) {
			System.out.println("***************");
			System.out.println(noofrows + " row inserted Successfully !!!");
			System.out.println("***************");
			}
			else 
			{
				throw new PayrollGenerationException();
			}
			} 
		catch (PayrollGenerationException e) {
			System.out.println(e.getMessage());		
			}
		catch (SQLIntegrityConstraintViolationException e) 
		{
			System.out.println("Error: Please Check the details for employee ID " +pr.getEmployeeId());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * Retrieves and displays details of a payroll record based on the given payroll ID.
	 * 
	 * @param payrollId The ID of the payroll record to retrieve.
	 * @return Details are printed to the console.
	 */
	public String payrollById(int payrollId) {
		try {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("SELECT CONCAT(firstName,\" \", lastName) as Name, position , p.*\n"
					+ " FROM payroll p\n"
					+ " join employee o\n"
					+ " on p.employeeid = o.employeeid"
					+ " where payrollid = ?");

			ps.setInt(1, payrollId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("***************");
				System.out.println("Employee Name: " +rs.getString(1));
				System.out.println("Position: " +rs.getString(2));
				System.out.println("Payroll ID: " + rs.getInt(3));
				System.out.println("Employee ID: " + rs.getInt(4));
				System.out.println("Pay Period Start Date: " + rs.getString(5));
				System.out.println("Pay Period End Date: " + rs.getString(6));
				System.out.println("Basic Salary: " + rs.getDouble(7));
				System.out.println("Overtime Pay: " + rs.getDouble(8));
				System.out.println("Deductions: " + rs.getDouble(9));
				System.out.println("***************");
			} else {
				System.out.println("Payroll record with ID " + payrollId + " not found.");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Retrieves and displays details of payroll records associated with a specific employee ID.
	 * 
	 * @param employeeId The unique identifier of the employee to retrieve payroll records for.
	 * @return Details are printed to the console.
	 */
	public String payrollByEmployeeId(int employeeId) {
		try {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("SELECT CONCAT(firstName,\" \", lastName) as Name, position , p.*\n"
					+ " FROM payroll p\n"
					+ " join employee o\n"
					+ " on p.employeeid = o.employeeid\n"
					+ " where p.employeeid = ?;");

			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if(!esdb.isValidEmployee(employeeId)) {
				System.out.println("Employee ID Not Found");
			}
			else {
			int record = 0;
			while (rs.next()) {
				record = 1;
				System.out.println("***************");
				System.out.println("Employee Name: " +rs.getString(1));
				System.out.println("Position: " +rs.getString(2));
				System.out.println("Payroll ID: " + rs.getInt(3));
				System.out.println("Employee ID: " + rs.getInt(4));
				System.out.println("Pay Period Start Date: " + rs.getString(5));
				System.out.println("Pay Period End Date: " + rs.getString(6));
				System.out.println("Basic Salary: " + rs.getDouble(7));
				System.out.println("Overtime Pay: " + rs.getDouble(8));
				System.out.println("Deductions: " + rs.getDouble(9));
				System.out.println("***************");
			}
			if(record == 0) {
				System.out.println("No Payroll records available.");
			}
	} }
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Retrieves and displays details of payroll records for a specific period.
	 * 
	 * @param startDate The start date of the payroll period.
	 * @param endDate   The end date of the payroll period.
	 * @return The payroll details for the specified period.
	 */

	public String getPayrollsForPeriod(String startDate, String endDate) {
	    StringBuilder result = new StringBuilder();  

	    try {
	        ps = connection.prepareStatement("SELECT CONCAT(firstName,\" \", lastName) as Name, position , p.*\n"
	        		+ " FROM payroll p\n"
	        		+ " join employee o\n"
	        		+ " on p.employeeid = o.employeeid\n"
	        		+ " WHERE PayPeriodStartDate >= ? AND PayPeriodEndDate <= ?");
	        ps.setString(1, startDate);
	        ps.setString(2, endDate);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            result.append("***************");
	            result.append("\nEmployee Name: ").append(rs.getString(1));
	            result.append("\nPosition: ").append(rs.getString(2));
	            result.append("\nPayroll ID: ").append(rs.getInt(3));
	            result.append("\nEmployee ID: ").append(rs.getInt(4));
	            result.append("\nPay Period Start Date: ").append(rs.getString(5));
	            result.append("\nPay Period End Date: ").append(rs.getString(6));
	            result.append("\nBasic Salary: ").append(rs.getDouble(7));
	            result.append("\nOvertime Pay: ").append(rs.getDouble(8));
	            result.append("\nDeductions: ").append(rs.getDouble(9));
	            result.append("\n***************\n");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result.toString(); 
	}
	/**
	 * Retrieves the gross salary details for a particular employee. 
	 * @return Returns an array containing gross salary details.
	 */
	public double[] grossSalaryDetails() {
		    double[] arr = null;

		    try {
		    	stmt = connection.createStatement();
		        ps = connection.prepareStatement("SELECT basicsalary, overtimepay, deductions, grosssalary " +
		                "FROM payroll p " +
		                "JOIN salary s ON p.payrollid = s.payrollid"
		                + " WHERE s.PayrollID = 327");
		        ResultSet rs = ps.executeQuery();
		        arr = new double[4]; 

		        while (rs.next()) {
		            arr[0] = rs.getDouble(1); // BasicSalary
		            arr[1] = rs.getDouble(2); // OvertimePay
		            arr[2] = rs.getDouble(3); // Deductions
		            arr[3] = rs.getDouble(4); // Gross Salary
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return arr;
		}
	
	/**
	 * Retrieves the net salary details for a particular employee. 
	 * @return Returns an array containing net salary details.
	 */
	
	public double[] netSalaryDetails() {
	    double[] arr = null;

	    try {
	    	stmt = connection.createStatement();
	        ps = connection.prepareStatement("SELECT basicsalary, overtimepay, deductions, netsalary " +
	                "FROM payroll p " +
	                "JOIN salary s ON p.payrollid = s.payrollid"
	                + " WHERE s.PayrollID = 327");
	        ResultSet rs = ps.executeQuery();
	        arr = new double[4]; 

	        while (rs.next()) {
	            arr[0] = rs.getDouble(1); // BasicSalary
	            arr[1] = rs.getDouble(2); // OvertimePay
	            arr[2] = rs.getDouble(3); // Deductions
	            arr[3] = rs.getDouble(4); // Net Salary
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return arr;
	}
	/**
	 *Checks whether the employee is terminated or not. 
	 *@param employeeId - The unique identifier of each employee.
	 *@return Returns whether the employee is terminated or not.
	 */
	public String isNotTerminated(int employeeId) throws NullPointerException {
		try {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("SELECT TerminationDate FROM Employee WHERE EmployeeID = ?");
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
	        if (rs.next()) 
	        {
	            if (rs.getString(1) == null) 
	            {
	                return "NotTerminated";
	            } 
	            else 
	            {
	                return "Terminated";
	            }
	        	} 
	            else 
	            {
	            throw new EmployeeNotFoundException();
	            }
	        }
		catch (EmployeeNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null; 
	}
}