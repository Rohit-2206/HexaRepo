/**
 * Controller Package.
 */

package com.hexaware.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.InputMismatchException;
import java.util.Random;

import java.util.Scanner;

import com.hexaware.dao.IEmployeeService;
import com.hexaware.entity.Employee;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.util.EmployeeServiceDb;

/**
 * It implements the IEmployeeService interface.
 */
public class EmployeeService implements IEmployeeService {
	EmployeeServiceDb esdb = new EmployeeServiceDb();
	ValidationService vs = new ValidationService();
	Employee emp;
	Scanner read = new Scanner(System.in);

	/**
	 * Retrieves employee details by ID.
	 * 
	 * @param employeeId The ID of the employee to retrieve details for.
	 * @return Employee details as a String.
	 */
	@Override
	public String getEmployeeById(int employeeId) {
		try {
			System.out.println("Enter the Employee ID");
			employeeId = read.nextInt();
			System.out.println(esdb.viewEmployeeById(employeeId));
		} catch (EmployeeNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid Input !!!");
			read.nextLine();
		}
		return "";
	}

	/**
	 * Displays details of all employees.
	 */
	@Override
	public void getAllEmployees() {
		System.out.println(esdb.showEmployee());
	}

	/**
	 * Adds a new employee by collecting and validating user input.
	 */
	@Override
	public void addEmployee() {

		emp = new Employee();

		int employeeId = generateRandom();
		emp.setEmployeeId(employeeId);

		System.out.println("Enter First Name of Employee");
		String firstName = read.next();
		emp.setFirstName(firstName);

		System.out.println("Enter Last Name of Employee");
		String lastName = read.next();
		emp.setLastName(lastName);

		System.out.println("Enter Date of Birth");
		String dob = read.next();
		while (!vs.isValidDate(dob)) {
			System.out.println("Invalid Date of Birth format. \nPlease enter in yyyy-mm-dd format.");
			dob = read.next();
		}
		emp.setDateOfBirth(dob);

		System.out.println("Enter Gender");
		String gender = read.next();
		emp.setGender(gender);

		System.out.println("Enter Email ID of the Employee");
		String emailId = read.next();
		while (!vs.isValidEmail(emailId)) {
			System.out.println("Invalid Email ID format.\nEnter correct Email ID");
			read.nextLine();
			emailId = read.next();
		}
		emp.setEmailId(emailId);

		System.out.println("Enter the contact number of employee");
		String phoneNumber = read.next();
		while(!vs.isValidPhoneNumber(phoneNumber)) {
			System.out.println("Phone number is incorrect.\nCheck and Type again");
			read.nextLine();
			phoneNumber = read.next();
		}
		emp.setPhoneNumber(phoneNumber);
		read.nextLine();

		System.out.println("Enter Address of the Employee");
		String address = read.nextLine();
		emp.setAddress(address);

		System.out.println("Enter the Position of the Employee");
		String position = read.nextLine();
		emp.setPosition(position);

		System.out.println("Enter Joining Date of Employee");
		String joining = read.nextLine();
		while (!vs.isValidDate(joining)) {
			System.out.println("Invalid Date format. \nPlease enter in yyyy-mm-dd format.");
			joining = read.next();
		}
		emp.setJoiningDate(joining);
		
		System.out.println("Emploee ID: "+employeeId);
		esdb.addEmployeeToDb(emp);
	}

	/**
	 * Generates a random integer number from the Random class.
	 * 
	 * @return A random non-negative integer.
	 */

	private int generateRandom() {
		Random random = new Random();
		int rand = Math.abs(random.nextInt());
		return rand;
	}

	/**
	 * Updates employee information by collecting and validating user input.
	 *
	 * @return A message indicating the success or failure of the employee updation.
	 */
	@Override
	public String updateEmployee() {

		emp = new Employee();

		System.out.println("Enter the EmployeeId to update");
		int employeeId = read.nextInt();
		emp.setEmployeeId(employeeId);
		read.nextLine();
		
		if(esdb.isValidEmployee(employeeId)) {
		Object reply;
		do {	
		System.out.println("What do you want to update");
		System.out.println("1.FirstName\n2.LastName\n3.DOB\n4.Gender\n5.Email ID\n"
				+ "6.ContactNumber\n7.Address\n8.Position\n"
				+ "9.Termination Date\n10.Updation Done");
		int choice = read.nextInt();
		switch(choice) {
		
		case 1:
			System.out.println("Enter First Name of Employee");
			String firstName = read.next();
			emp.setFirstName(firstName);
			break;
		
		case 2:
			System.out.println("Enter Last Name of Employee");
			String lastName = read.next();
			emp.setLastName(lastName);
			break;
		
		case 3:
			System.out.println("Enter Date of Birth");
			String dob = read.next();
			while (!vs.isValidDate(dob)) {
				System.out.println("Invalid Date of Birth format. \nPlease enter in yyyy-mm-dd format.");
				dob = read.next();
			}
			emp.setDateOfBirth(dob);
			break;
		
		case 4:
			System.out.println("Enter Gender");
			String gender = read.next();
			emp.setGender(gender);
			break;
	
		case 5:
			System.out.println("Enter Email ID of the Employee");
			String emailId = read.next();
			while (!vs.isValidEmail(emailId)) {
				System.out.println("Invalid Email ID format. \n Enter Correct Email");
				read.nextLine();
				emailId = read.next();
			}
			emp.setEmailId(emailId);
			break;
		
		case 6:
			System.out.println("Enter the contact number of employee");
			String phoneNumber = read.next();
			while(!vs.isValidPhoneNumber(phoneNumber)) {
				System.out.println("Phone number is incorrect.\nCheck and Type again");
				read.nextLine();
				phoneNumber = read.next();
			}
			emp.setPhoneNumber(phoneNumber);
			break;
			
		case 7:
			read.nextLine();
			System.out.println("Enter Address of the Employee");
			String address = read.nextLine();
			emp.setAddress(address);
			break;
		
		case 8:
			read.nextLine();
			System.out.println("Enter the Position of the Employee");
			String position = read.nextLine();
			emp.setPosition(position);
			break;
		
		case 9:
			read.nextLine();
			System.out.println("Enter Termination Date");
			String date = read.next();
			while (!vs.isValidDate(date)) {
				System.out.println("Invalid Date format. \nPlease enter in yyyy-mm-dd format.");
				date = read.next();
			}
			emp.setTerminationDate(date);
			break;
			
		case 10:
			break;
			
		default:
			System.out.println("Invalid choice");
		}
		System.out.println("Do you want to continue updation (Y/N)");
		reply = read.next();
		}while(reply.equals("Y") || reply.equals("y"));
		return esdb.updateEmployee(emp, employeeId);
		}
		else {
		System.out.println("***********");
		System.out.println("Not a Valid Employee");
		System.out.println("***********");
		return "";
		}
	}
	/**
	 * Removes an employee based on the provided employee ID.
	 *
	 * @param employeeId The ID of the employee to be removed.
	 * @throws SQLIntegrityConstraintViolationException If a SQL integrity constraint violation occurs.
	 */

	@Override
	public void removeEmployee(int employeeId) throws SQLIntegrityConstraintViolationException {
		try {
		System.out.println("Enter the employee ID to be removed");
		int empId = read.nextInt();
		System.out.println(esdb.removeEmployeeFromDb(empId));
		}catch(InputMismatchException e) {
			System.out.println("Invalid Input!!!");
		}
	}
}
