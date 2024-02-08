package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.CourierServiceDb;

public class Task2 {
	
	Scanner read = new Scanner(System.in);
	
	// 5. Write a Java program that uses a for 
	// loop to display all the orders for a specific customer.
	
	public void showOrders() {
		CourierServiceDb crdb = new CourierServiceDb();
		System.out.println("Enter your User ID");
		int userId = read.nextInt();

		System.out.println(crdb.showOrderForCustomer(userId));

	}
	
	public void trackLocation() {
		
		// Use pincodes such 600045 , 600046 to get a output
		System.out.println("Enter your current location pincode");
		int currLocation = read.nextInt();
		System.out.println("Enter your destination location pincode");
		int destLocation = read.nextInt();
		
		while(true) {			
            if (currLocation < destLocation) {
            	currLocation ++;
                System.out.println("Out for delivery. Current location: " + currLocation);
            } else if (currLocation > destLocation) {
            	currLocation --;
                System.out.println("Out for delivery. Current location: " + currLocation);
            } else if (currLocation == destLocation) {
            	System.out.println("Reached Destination "+destLocation);
            	break;
            }
        }
    }

	
	public static void main(String[] args) {
		Task2 t2 = new Task2();
		Scanner read = new Scanner(System.in);
		do {
		System.out.println("Enter Question Number");
		System.out.println(
				"1.Show orders made \n" + "2.Track the location of my package \n");
		int questionNumber = read.nextInt();
		switch (questionNumber) {
		case 1:
			t2.showOrders();
			break;
		case 2:
			t2.trackLocation();
			break;
		default:
			break;
		}
		}while(true);
	}
	
}