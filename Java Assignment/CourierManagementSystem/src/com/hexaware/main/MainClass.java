package com.hexaware.main;

import java.sql.SQLException;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.hexaware.controller.CourierAdminServiceImpl;
import com.hexaware.controller.CourierUserServiceImpl;
import com.hexaware.dao.ICourierAdminService;
import com.hexaware.dao.ICourierUserService;
import com.hexaware.entity.Courier;
import com.hexaware.entity.CourierCompany;
import com.hexaware.exception.InvalidEmployeeIDException;
import com.hexaware.exception.TrackingNumberNotFoundException;
import com.hexaware.exception.UserNotFoundException;

public class MainClass {
	static CourierCompany cc;
	
	public static void main(String[] args) throws InvalidEmployeeIDException, UserNotFoundException, TrackingNumberNotFoundException, SQLException {

		System.out.println("Welcome to our Courier Service");
		System.out.println("Enter 1 if your user and 2 if your admin");
		Scanner read = new Scanner(System.in);
		int choice = read.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter your username");
			String Username = read.next();
			System.out.println("Enter your password");
			String Password = read.next();
			try {
				if (Username.equals("Rohit") && Password.equals("12345")) {
					System.out.println("Login Successful");
					userOptions();
				} else {
					throw new UserNotFoundException();
				}
			} catch (UserNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;

		case 2:
			System.out.println("Enter your username");
			String Adminname = read.next();
			System.out.println("Enter your password");
			String AdminPassword = read.next();
			try {
				if (Adminname.equals("admin") && AdminPassword.equals("12345")) {
					System.out.println("Login Succesfull");
					adminOptions();
				} else {
					throw new UserNotFoundException();
				}} catch (UserNotFoundException e) {
					System.out.println(e.getMessage());
				}
	
			break;

		default:
			System.out.println("Invalid choice");
			read.close();
		}
	}

	private static void userOptions() throws TrackingNumberNotFoundException, SQLException {

		ICourierUserService cus = new CourierUserServiceImpl(cc);
		Courier cr = new Courier();
		Scanner read = new Scanner(System.in);
		try {
			do {
				System.out.println("User Options:");
				System.out.println("1. Place Order");
				System.out.println("2. Show Orders");
				System.out.println("3. Get Order Status");
				System.out.println("4. Cancel Order");
				System.out.println("6. Logout");

				int choice = read.nextInt();

				switch (choice) {

				case 1:
					cus.placeOrder(cr);
					break;

				case 2:
					cus.showOrders();
					break;

				case 3:
					cus.getOrderStatus(cr.getTrackingNumber());
					break;

				case 4:
					cus.cancelOrder(cr.getTrackingNumber());
					break;

				case 6:
					System.out.println("Logged out.");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice. Try again.");
				}
			} while (true);
		} catch (ConcurrentModificationException cme) {
			System.out.println("Cancelled order");
		} catch (InputMismatchException ime) {
			System.out.println("Enter Correct value");
		}
	}

	private static void adminOptions() throws InvalidEmployeeIDException {
		ICourierAdminService cas = new CourierAdminServiceImpl(cc);
		Courier cr = new Courier();
		Scanner read = new Scanner(System.in);

		while (true) {
			System.out.println("Admin Options:");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employees");
			System.out.println("3. View All Orders");
			System.out.println("4. View Assigned Orders");
			System.out.println("5. Generate report");
			System.out.println("6. Logout");

			int choice = read.nextInt();

			switch (choice) {
			case 1:
				cas.addCourierStaff();
				break;
			case 2:
				cas.viewEmployee();
				break;
			case 3:
				cas.viewAllOrders();
				break;
			case 4:
				cas.showAssignedOrders(cr.getEmployeeId());
				break;
			case 5:
				cas.generateReport();
				break;
			case 6:
				System.out.println("Logged out.");
				return;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}
