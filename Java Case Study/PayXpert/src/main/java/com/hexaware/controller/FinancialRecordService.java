/**
 *Controller Package. 
 */

package com.hexaware.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.hexaware.dao.IFinancialRecordService;
import com.hexaware.entity.FinancialRecord;
import com.hexaware.util.FinancialRecordServiceDb;

/**
 * Implements the IFinancialRecordService interface.
 */
public class FinancialRecordService implements IFinancialRecordService {

	FinancialRecordServiceDb frdb = new FinancialRecordServiceDb();
	FinancialRecord fr;
	ValidationService vs = new ValidationService();
	Scanner read = new Scanner(System.in);

	/**
	 * Adds a new financial record for an employee.
	 *
	 * @param employeeId The ID of the employee associated with the financial record.
	 * @param description The description of the financial record.
	 * @param amount The amount associated with the record.
	 * @param recordType The type of the financial record.
	 */
	
	@Override
	public void addFinancialRecord(int employeeId, String description, double amount, String recordType) {

		fr = new FinancialRecord();

		System.out.println("Enter employee ID");
		employeeId = read.nextInt();
		fr.setEmployeeId(employeeId);

		System.out.println("Enter Record Date");
		String date = read.next();
		while (!vs.isValidDate(date)) {
		    System.out.println("Invalid Date format.\nPlease enter in yyyy-mm-dd format.");
		    read.nextLine();
		    date = read.next();
		}
		fr.setRecordDate(date);

		System.out.println("Enter Description for the record");
		read.nextLine();
		description = read.nextLine();
		fr.setDescription(description);
		try {
		System.out.println("Enter amount for the record");
		amount = read.nextDouble();
		fr.setAmount(amount);
		}catch (InputMismatchException e) {
			System.out.println("Wrong Input Please Check");
			read.nextLine();
		}
		System.out.println("Enter record type");
		recordType = read.next();
		fr.setRecordType(recordType);
		
		frdb.addFinancialRecord(fr);
	}

	/**
	 * Retrieves and displays the financial record information based on the provided record ID.
	 *
	 * @param recordId The ID of the financial record to be searched.
	 */
	@Override
	public void getFinancialRecordById(int recordId) {
		try {
		System.out.println("Enter the record ID you want to search");
		recordId = read.nextInt();
		
		System.out.println(frdb.recordById(recordId));
		}catch(InputMismatchException e) {
			System.out.println("Invalid Input");
			read.nextLine();
		}
	}

	/**
	 * Retrieves and displays financial records associated with a specific employee.
	 *
	 * @param employeeId The ID of the employee for whom financial records are to be retrieved.
	 */
	@Override
	public void getFinancialRecordsForEmployee(int employeeId) {
		try {
		System.out.println("Enter the employee ID");
		employeeId = read.nextInt();
		System.out.println(frdb.recordByEmployeeId(employeeId));
		}catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			read.nextLine();
		}
	}

	/**
	 * Retrieves and displays financial records based on the provided record date.
	 *
	 * @param recordDate The date for which financial records are to be retrieved (in yyyy-mm-dd format).
	 */
	@Override
	public void getFinancialRecordsForDate(String recordDate) {
		System.out.println("Enter the Recorded Date ");
		recordDate = read.next();
		while (!vs.isValidDate(recordDate)) {
		    System.out.println("Invalid Date format. \nPlease enter in yyyy-mm-dd format.");
		    recordDate = read.next();
		}
		System.out.println(frdb.recordByDate(recordDate));
	}

}
