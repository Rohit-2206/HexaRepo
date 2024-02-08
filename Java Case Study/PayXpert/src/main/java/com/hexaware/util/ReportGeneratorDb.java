/*
 *Util Package. 
 */
package com.hexaware.util;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ReportGeneratorDb class is responsible for generating reports based on the data
 * retrieved from the database.
 */
public class ReportGeneratorDb {

	Connection connection;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;

	/**
	 * Establishing a connection to the database.
	 */
	public ReportGeneratorDb(){
		connection = DBConnectionUtil.getConnection();
	}
	/**
	 * Retrieves and displays the total amount paid to each employee for a specific year.
	 * 
	 * @param year The year for which the details need to be retrieved.
	 * @return An empty string as the method prints the details to the console.
	 */
	public String salaryPaidByYear(int year) {
		try {
			ps = connection.prepareStatement(
					"SELECT EmployeeID , MAX(PaidAmount) as \"Total Amount Paid\"\r\n" + "FROM payslip\r\n"
							+ "WHERE taxyear = (SELECT distinct taxyear from payslip where taxyear = ?)\r\n"
							+ "group by employeeid\r\n" + "ORDER BY MAX(paidamount) DESC;");
			ps.setInt(1, year);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("***************");
				System.out.println("Employee ID : " + rs.getInt(1));
				System.out.println("Amount Paid : " + rs.getInt(2));
				System.out.println("***************");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Retrieves and displays the total salary paid and the number of employees for each month in a specific year.
	 * 
	 * @param year The year for which salary details need to be retrieved.
	 * @return An empty string as the method prints the details to the console.
	 */
	public String salaryPaidByMonth(int year) {
		try {
			ps = connection.prepareStatement(
					"SELECT PayMonth , PayYear , SUM(GrossSalary) \"Total Salary Paid\", COUNT(EmployeeID) \"Number of Employees\"\r\n"
							+ "FROM Salary \r\n" + "WHERE PayYear = ? " + "GROUP BY PayMonth , PayYear;");
			ps.setInt(1, year);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("***************");
				System.out.println("Pay Month: " + rs.getString(1));
				System.out.println("Pay Year: " + rs.getInt(2));
				System.out.println("Total Salary Paid : " + rs.getDouble(3));
				System.out.println("Number of Employees : " + rs.getInt(4));
				System.out.println("***************");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "";
	}
	/**
	 * Retrieves and displays salary details for a specific employee.
	 * 
	 * @param employeeId The ID of the employee for whom salary details need to be retrieved.
	 * @return An empty string as the method prints the details to the console.
	 */
	public String salaryPaidByEmployee(int employeeId) {
		try {
			ps = connection.prepareStatement(
					"SELECT salary.EmployeeID , CONCAT(firstName,\" \", lastName) as Name, PayMonth , PayYear, GrossSalary \r\n"
							+ "FROM Salary\r\n" + "JOIN Employee\r\n" + "ON salary.employeeid = employee.employeeid\r\n"
							+ "WHERE salary.EmployeeID = ?;");
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("***************");
				System.out.println("EmployeeID: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Pay Month: " + rs.getString(3));
				System.out.println("Pay Year : " + rs.getInt(4));
				System.out.println("Gross Salary: " + rs.getDouble(5));
				System.out.println("***************");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "";
	}
}
