package com.hexaware.controller;

import java.util.Scanner;

public class Task4 {
	Scanner read = new Scanner(System.in);

	// 9. Parcel Tracking

	public void trackLocation() {
		System.out.println("Enter your current location pincode");
		int currLocation = read.nextInt();
		System.out.println("Enter your destination location pincode");
		int destLocation = read.nextInt();

		String[][] trackingHistory = new String[100][2];
		int i = 0;

		while (true) {
			if (currLocation < destLocation) {
				currLocation++;
				System.out.println("Out for delivery. Current location: " + currLocation);
			} else if (currLocation > destLocation) {
				currLocation--;
				System.out.println("Out for delivery. Current location: " + currLocation);
			} else if (currLocation == destLocation) {
				trackingHistory[i][0] = "Reached Destination";
				System.out.println("Reached Destination " + destLocation);
				break;
			}
			if (currLocation != destLocation) {
				trackingHistory[i][0] = "Out for delivery";
			} else if (currLocation == destLocation) {
				trackingHistory[i][0] = "Reached Destination";
			}
			trackingHistory[i][1] = String.valueOf(currLocation);
			i++;
		}
		System.out.println("Tracking History:");
		for (int j = 0; j < i; j++) {
			System.out.println("Update " + (j + 1) + ": Status - " + trackingHistory[j][0] + ", Current Location - "
					+ trackingHistory[j][1]);
		}
	}

	// 13. Calculate Shipping Costs
	public void shippingCost() {
		System.out.println("Enter your current location pincode");
		int currLocation = read.nextInt();
		System.out.println("Enter your destination location pincode");
		int destLocation = read.nextInt();
		System.out.println("Enter parcel weight");
		double weight = read.nextDouble();

		int distance = Math.abs(currLocation - destLocation);

		if (distance > 0) {
			if (weight <= 10) {
				double cost = 100 + weight * 0.05;
				System.out.println("Shipping Cost " + cost);
			} else if (weight <= 30) {
				double cost = 200 + weight * 0.05;
				System.out.println("Shipping Cost " + cost);
			} else if (weight <= 50) {
				double cost = 350 + weight * 0.5;
				System.out.println("Shipping Cost " + cost);
			} else {
				double cost = 500 + weight * 0.5;
				System.out.println("Shipping Cost " + cost);
			}
		} else if (distance > 20) {
			if (weight <= 10) {
				double cost = 150 + weight * 0.05;
				System.out.println("Shipping Cost " + cost);
			} else if (weight <= 30) {
				double cost = 250 + weight * 0.05;
				System.out.println("Shipping Cost " + cost);
			} else if (weight <= 50) {
				double cost = 450 + weight * 0.5;
				System.out.println("Shipping Cost " + cost);
			} else {
				double cost = 600 + weight * 0.5;
				System.out.println("Shipping Cost " + cost);
			}
		} else if (distance > 50) {
			if (weight <= 10) {
				double cost = 300 + weight * 0.05;
				System.out.println("Shipping Cost " + cost);
			} else if (weight <= 30) {
				double cost = 500 + weight * 0.05;
				System.out.println("Shipping Cost " + cost);
			} else if (weight <= 50) {
				double cost = 700 + weight * 0.5;
				System.out.println("Shipping Cost " + cost);
			} else {
				double cost = 900 + weight * 0.5;
				System.out.println("Shipping Cost " + cost);
			}
		} else {
			System.out.println("Standard Cos: 3000");
		}
	}

	// 14. Password Generator:
	public void passwordGenerator() {
		System.out.println("Enter your username");
		String userName = read.next();
		System.out.println("Do you want to generate password(Reply with Yes or No)");
		String reply = read.next();
		if (reply.equals("Yes") || reply.equals("yes")) {
			System.out.println("Your secure password is" + generator());
		} else {
			System.out.println("Thank You for confirming");
		}
	}

	private String generator() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz" + "@_-";
		StringBuilder s = new StringBuilder(10);
		for (int y = 0; y < 10; y++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			s.append(AlphaNumericString.charAt(index));
		}
		return s.toString();
	}

	public static void main(String[] args) {
		Task4 t4 = new Task4();
		// t4.passwordGenerator();
		// t4.trackLocation();
		t4.shippingCost();
		// t4.similarAddress();
	}

}

