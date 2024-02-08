package com.hexaware.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.hexaware.dao.CourierServiceDb;
import com.hexaware.dao.ICourierAdminService;
import com.hexaware.entity.CourierCompany;
import com.hexaware.entity.Employee;
import com.hexaware.exception.InvalidEmployeeIDException;

// Task 6 Courier Admin Service
// Task 8.2 

public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService {

	public CourierAdminServiceImpl(CourierCompany companyObj) {
		super(companyObj);
		// TODO Auto-generated constructor stub
	}

	List<Employee> empList = new ArrayList<Employee>();
	Employee emp;
	Scanner read = new Scanner(System.in);
	
	/**
	 * 
	 * This method is used to add a new employee to the database
	 * 
	 * */
	public void addCourierStaff() {

		CourierServiceDb courierServiceDb = new CourierServiceDb();

		emp = new Employee();

		int employeeId = generateRandom();
		emp.setEmployeeId(employeeId);

		System.out.println("Enter Employee Name");
		String employeeName = read.next();
		emp.setEmployeeName(employeeName);

		System.out.println("Enter Enter EmailID");
		String emailId = read.next();
		emp.setEmailId(emailId);

		System.out.println("Enter Contact Number");
		String contactNumber = read.next();
		emp.setContactNumber(contactNumber);

		System.out.println("Enter role for the employee");
		String role = read.next();
		emp.setRole(role);

		System.out.println("Enter salary");
		double salary = read.nextDouble();
		emp.setSalary(salary);

		empList.add(emp);

		courierServiceDb.addEmployee(emp);
		System.out.println("Employee " + employeeName + " added Successfully !!!");
	}
	/*
	 * Generate a random positive number 
	 * 
	 * */
	private int generateRandom() {
		Random random = new Random();
		int rand = Math.abs(random.nextInt());
		return rand;
	}

	/**
	 * 
	 * This method is used to view all employee details
	 * 
	 * */
	public void viewEmployee() {
		System.out.println("*** " + empList + "****");
		CourierServiceDb courierServiceDb = new CourierServiceDb();
		courierServiceDb.showEmployee();
	}
	
	/**
	 * 
	 * This method is used to view all orders that has been placed
	 * 
	 * */
	public void viewAllOrders() {
		CourierServiceDb courierServiceDb = new CourierServiceDb();
		courierServiceDb.viewAllOrders();
	}
	/**
	 * 
	 * This method is used to view orders that has been assigned to a specific employee
	 * 
	 * */
	public void showAssignedOrders(int employeeId) throws InvalidEmployeeIDException {
		CourierServiceDb crdb = new CourierServiceDb();
		System.out.println("Enter staff ID");
		employeeId = read.nextInt();
		try {
		System.out.println(crdb.showAssignedOrders(employeeId));
		}catch(InvalidEmployeeIDException e) {
			System.out.println(e.getMessage());
		}
		} 
	/**
	 * 
	 * This method is used to generate report based on the number of orders placed by each customer
	 * 
	 * */
	public void generateReport() {
		CourierServiceDb crdb = new CourierServiceDb();
		System.out.println(crdb.reportGeneration());
	}
}
