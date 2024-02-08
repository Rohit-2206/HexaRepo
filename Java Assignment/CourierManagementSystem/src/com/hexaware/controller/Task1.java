package com.hexaware.controller;

import java.util.Scanner;
import com.hexaware.entity.Courier;

public class Task1 {

	Courier cr = new Courier();
	Scanner read = new Scanner(System.in);

	// Task-1 Question 1

	public void deliveryStatus() {
		System.out.println("Enter Courier ID");
		int CourierID = read.nextInt();

		if (CourierID == 12345) {
			System.out.println("Delivered");
		} else {
			System.out.println("Processing");
		}
	}

	// Task-1 Question 2

	public void weightCategory() {
		System.out.println("Weight of the package");
		double weight = read.nextDouble();
		if (weight > 0 && weight < 20) {
			System.out.println("Light");
		} else if (weight > 21 && weight < 50) {
			System.out.println("Medium");
		} else if (weight > 51 && weight < 100) {
			System.out.println("Heavy");
		} else {
			System.out.println("Very Heavy");
		}
	}

	// Task-1 Question 3

	public void userAuthentication() {

		System.out.println("Welcome to our Courier Management System");
		System.out.println("Choose your login method");
		System.out.println("1.User Login \n" + "2.Admin Login \n");
		int choice = read.nextInt();

		switch (choice) {

		case 1:
			System.out.println("Enter your user name");
			String userName = read.next();
			System.out.println("Enter your password");
			String password = read.next();
			if (userName.equals("Rohit") && password.equals("12345")) {
				System.out.println("Login Sucessfull");
			} else {
				System.out.println("Invalid Username or Password");
			}
			break;

		case 2:
			System.out.println("Enter admin name");
			String adminName = read.next();
			System.out.println("Enter admin password");
			String adminPass = read.next();
			if (adminName.equals("admin") && adminPass.equals("pass")) {
				System.out.println("Login Sucessfull");
			} else {
				System.out.println("Enter valid credentials");
			}
			break;
		}
	}

	// Task -1 Question 4

	public void courierAssignment() {

		System.out.println("Enter weight of the courier");

		double weight = read.nextDouble();

		if (weight > 0 && weight < 10) {
			System.out.println("MotorCycle Delivery");
		} else if (weight > 10.01 && weight < 19.99) {
			System.out.println("Mini Truck Delivery");
		} else if (weight > 20.01 && weight < 40.99) {
			System.out.println("Truck Delivery");
		} else {
			System.out.println("Load Truck Delivery");
		}

	}

	public static void main(String[] args) {
		Task1 t1 = new Task1();
		Scanner read = new Scanner(System.in);
		do {
		System.out.println("Enter Question Number");
		System.out.println(
				"1.Delivery Status \n" + "2.Weight Category \n" + "3.User Authentication \n" + "4.Courier Assignment");
		int questionNumber = read.nextInt();
		switch (questionNumber) {
		case 1:
			t1.deliveryStatus();
			break;
		case 2:
			t1.weightCategory();
			break;
		case 3:
			t1.userAuthentication();
			break;
		case 4:
			t1.courierAssignment();
			break;
		default:
			break;
		}
		}while(true);
	}
}
