/*
 *Util Package. 
 */
package com.hexaware.util;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.FinancialRecord;

/**
 * FinancialRecordServiceDb class provides database operations related to financial records.
 */
public class FinancialRecordServiceDb {

	Connection connection;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	EmployeeServiceDb esdb = new EmployeeServiceDb();

	/**
	 * Establishing connection with the database. 
	 */
	public FinancialRecordServiceDb() {
		connection = DBConnectionUtil.getConnection();
	}
	/**
	 * Adds a new financial record for an employee to the database.
	 * 
	 * @param fr The FinancialRecord object containing the details of the financial record.
	 */

	public void addFinancialRecord(FinancialRecord fr) {

		try {
			ps = connection.prepareStatement(
					"INSERT INTO FinancialRecord(employeeid,recorddate,description,amount,recordtype) VALUES(?,?,?,?,?)");
			ps.setInt(1, fr.getEmployeeId());
			ps.setString(2, fr.getRecordDate());
			ps.setString(3, fr.getDescription());
			ps.setDouble(4, fr.getAmount());
			ps.setString(5, fr.getRecordType());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Retrieves and displays the financial record details based on the provided record ID.
	 * 
	 * @param recordId The record ID of the financial record to be retrieved.
	 * @return A message indicating whether a data has been retrieved or not.
	 */
	public String recordById(int recordId){
		try {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("SELECT recordid, f.employeeid, CONCAT(firstName,\" \", lastName) as Name, recorddate , description, amount , Recordtype\n"
					+ " FROM financialRecord f\n"
					+ " join employee e \n"
					+ " on f.employeeid = e.employeeid\n"
					+ " WHERE recordid = ?");

			ps.setInt(1, recordId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("***************");
				System.out.println("Record ID: " + rs.getInt(1));
				System.out.println("Employee ID: " + rs.getInt(2));
				System.out.println("Employee Name: " + rs.getString(3));
				System.out.println("Record Date: " + rs.getString(4));
				System.out.println("Description: " + rs.getString(5));
				System.out.println("Amount: " + rs.getDouble(6));
				System.out.println("Record Type: " + rs.getString(7));
				System.out.println("***************");
				return "";
			}
			else 
			{
				return "No records found with ID " + recordId;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			return "Error occurred while retrieving record\n";
		}
	}
	/**
	 * Retrieves and displays the financial records associated with the provided employee ID.
	 * 
	 * @param employeeId The employee ID of the employee for whom financial records are to be retrieved.
	 * @return Details of the method are printed to the console.
	 */
	public String recordByEmployeeId(int employeeId) {
		try {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("SELECT recordid, f.employeeid, CONCAT(firstName,\" \", lastName) as Name, recorddate , description, amount , recordtype\n"
					+ " FROM financialRecord f\n"
					+ " join employee e \n"
					+ " on f.employeeid = e.employeeid\n"
					+ " WHERE f.employeeid = ?");
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if(esdb.isValidEmployee(employeeId)) {
			int records = 0;
			while(rs.next()) {
				records = 1; // If atleast one record is found it changes to 1 , else will be in 0
				System.out.println("***************");
				System.out.println("Record ID: " + rs.getInt(1));
				System.out.println("Employee ID: " + rs.getInt(2));
				System.out.println("Employee Name: " + rs.getString(3));
				System.out.println("Record Date: " + rs.getString(4));
				System.out.println("Description: " + rs.getString(5));
				System.out.println("Amount: " + rs.getDouble(6));
				System.out.println("Record Type: " + rs.getString(7));
				System.out.println("***************");
			}
	        if (records == 0) {
	            System.out.println("No records found with Employee ID " + employeeId);
	        }
		} else {
			System.out.println("Employee ID not found");
		}}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * Retrieves and displays the financial records associated with the provided record date.
	 * 
	 * @param recordDate The date for which financial records are to be retrieved.
	 * @return Details of the method are printed to console.
	 */
	public String recordByDate(String recordDate) {

		try {
			ps = connection.prepareStatement("SELECT recordid, f.employeeid, CONCAT(firstName,\" \", lastName) as Name, recorddate , description, amount , recordtype\n"
					+ " FROM financialRecord f\n"
					+ " join employee e \r\n"
					+ " on f.employeeid = e.employeeid\n"
					+ " WHERE recorddate = ?");
			ps.setString(1, recordDate);
			ResultSet rs = ps.executeQuery();
			int records = 0;
			while (rs.next()) {
				records = 1;
				System.out.println("***************");
				System.out.println("Record ID: " + rs.getInt(1));
				System.out.println("Employee ID: " + rs.getInt(2));
				System.out.println("Employee Name: " + rs.getString(3));
				System.out.println("Record Date: " + rs.getString(4));
				System.out.println("Description: " + rs.getString(5));
				System.out.println("Amount: " + rs.getDouble(6));
				System.out.println("Record Type: " + rs.getString(7));
				System.out.println("***************");
			}
			if(records == 0) {
				return "No records found for the date "+recordDate;
			}
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
		return "Error Occcured while retrieving data.";
	}
	return "";

}
}
