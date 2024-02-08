package com.hexaware.entity;

public class Employee {

	// Task 5.3 Creation of Employee Class
	// Variables employeeID , employeeName ,
	// email , contactNumber , role String, salary

	private int employeeId;
	private String employeeName;
	private String emailId;
	private String contactNumber;
	private String role;
	private double salary;

	public Employee() {

	}

	public Employee(int employeeId, String employeeName, String emailId, String contactNumber, String role,
			double salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.role = role;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Employee Details: " + ", EmployeeID: " + employeeId + ", Employee Name: " + employeeName + ", EmailID: "
				+ emailId + ", Contact Number" + contactNumber + ", Role: " + role + ", Salary: " + salary;
	}
}
