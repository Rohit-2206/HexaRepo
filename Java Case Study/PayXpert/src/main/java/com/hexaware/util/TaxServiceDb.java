/*
 * Util Package.
 */
package com.hexaware.util;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *A class for managing tax related services in database. 
 */
public class TaxServiceDb {
	EmployeeServiceDb esdb = new EmployeeServiceDb();
	Connection connection;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;

	/**
	 *This constructor establishes a connection to the database.
	 */
	public TaxServiceDb() {
		connection = DBConnectionUtil.getConnection();
	}

	/**
	 * Retrieves and displays tax details for a specific tax ID.
	 * 
	 * @param taxId The ID of the tax record to be retrieved.
	 * @return An empty string as the method prints the tax details to the console.
	 */
	public String taxById(int taxId) {
		try {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("SELECT taxid , t.employeeid ,CONCAT(firstName,\" \", lastName) as Name,taxyear, taxableincome, taxamount\n"
					+ " FROM tax t\n"
					+ " join employee e\n"
					+ " on t.employeeid = e.employeeid\n"
					+ " WHERE taxid = ?");

			ps.setInt(1, taxId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("***************");
				System.out.println("Tax ID: " + rs.getInt(1));
				System.out.println("Employee ID: " + rs.getInt(2));
				System.out.println("Employee Name: " +rs.getString(3));
				System.out.println("Tax Year: " + rs.getInt(4));
				System.out.println("Taxable Income: " + rs.getString(5));
				System.out.println("Tax Amount: " + rs.getDouble(6));
				System.out.println("***************");
			} else {
				System.out.println("Tax record for ID " + taxId + " not found.");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Retrieves and displays tax details for a specific employee ID.
	 * 
	 * @param employeeId The ID of the employee for whom tax details need to be
	 *                   retrieved.
	 * @return An empty string as the method prints the tax details to the console.                
	 */
	public String taxByEmployeeId(int employeeId) {
		try {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("SELECT  t.employeeid, CONCAT(firstName,\" \", lastName) as Name, t.taxyear, MAX(paidamount), MAX(t.taxableincome), MAX(t.taxamount)\n"
					+ " FROM tax t\n"
					+ " join employee e\n"
					+ " on e.employeeid = t.employeeid\n"
					+ " join payslip s\n"
					+ " on s.employeeid = t.employeeid\n"
					+ " WHERE t.employeeid = ?"
					+ " group by s.employeeid , t.taxyear\n");
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
				System.out.println("Employee ID: " + rs.getInt(1));
				System.out.println("Employee Name: " + rs.getString(2));
				System.out.println("Tax Year: " + rs.getString(3));
				System.out.println("Gross Salary: " +rs.getDouble(4));
				System.out.println("Taxable Income: " + rs.getDouble(5));
				System.out.println("Tax Amount: " + rs.getDouble(6));
				System.out.println("***************");
			} 
			if(record == 0) {
				System.out.println("No Payroll records available.");
			}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Retrieves and displays tax details for a specific tax year.
	 * 
	 * @param year The tax year for which tax details need to be retrieved.
	 * @return A formatted string containing tax details for the specified year.
	 */
	public String taxByYear(int year) {
		StringBuilder result = new StringBuilder();
		try {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("SELECT * FROM tax WHERE taxyear = ?");
			ps.setInt(1, year);
		    ResultSet rs = ps.executeQuery();

		    while (rs.next()) {
		        result.append("***************");
		        result.append("\nTax ID: ").append(rs.getInt(1));
		        result.append("\nEmployee ID: ").append(rs.getInt(2));
		        result.append("\nTax Year: ").append(rs.getString(3));
		        result.append("\nTaxable Income: ").append(rs.getString(4));
		        result.append("\nTax Amount: ").append(rs.getDouble(5));
		        result.append("\n***************\n");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return result.toString();  
		}
	
	/**
	 * Calculates and displays the tax details for a specific employee in a given
	 * tax year.
	 * 
	 * @param employeeId The ID of the employee for whom tax details need to be
	 *                   calculated.
	 * @param year       The tax year for which tax details need to be calculated.
	 * @throws           SQLException when a error occurs in the database side.
	 * @return           Returns the total amount paid.
	 */
	
	public double calculateTax(int employeeId , int year) throws SQLException {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("select employeeid,count(*),max(paidamount)\n"
					+ " from payslip\r\n"
					+ " WHERE employeeid = ? AND taxyear = ?"
					+ " group by employeeid , taxyear");
			ps.setInt(1, employeeId);
			ps.setInt(2, year);
			ResultSet rs = ps.executeQuery();
			
			double paidAmount = 0.0;
			
			while(rs.next()) {
				System.out.println("Employee ID: "+rs.getString(1));
				System.out.println("Number of months paid: "+rs.getInt(2));
				paidAmount = rs.getDouble(3);
				System.out.println("Paid Amount: "+paidAmount);
			}

		return paidAmount;
	}
}
