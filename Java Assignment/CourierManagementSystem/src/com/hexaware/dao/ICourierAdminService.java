package com.hexaware.dao;

import com.hexaware.exception.InvalidEmployeeIDException;

public interface ICourierAdminService {

	// Task 6 Courier Admin Service

	public void addCourierStaff();

	public void viewEmployee();

	public void viewAllOrders();

	public void showAssignedOrders(int employeeId) throws InvalidEmployeeIDException;
	
	public void generateReport();


}
