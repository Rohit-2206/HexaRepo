package com.hexaware.controller;

import java.util.Scanner;

public class Task3 {

	Scanner read = new Scanner(System.in);

	public void trackLocation() {
		System.out.println("Enter your current location pincode");
		int currLocation = read.nextInt();
		System.out.println("Enter your destination location pincode");
		int destLocation = read.nextInt();

		int[] trackingHistory = new int[100];
		int i = 0;

		while (true) {
			if (currLocation < destLocation) {
				currLocation++;
				System.out.println("Out for delivery. Current location: " + currLocation);
			} else if (currLocation > destLocation) {
				currLocation--;
				System.out.println("Out for delivery. Current location: " + currLocation);
			} else if (currLocation == destLocation) {
				System.out.println("Reached Destination " + destLocation);
				break;
			}
			trackingHistory[i] = currLocation;
			i++;
		}
		System.out.println("Tracking History:");
		for (int j = 0; j < i; j++) {
			System.out.println("Update " + (j + 1) + " Current Location " + trackingHistory[j]);
		}
	}

	public void nearestCourier() {
		int[] couriers = { 600045, 600050, 600055, 600091 };

		System.out.println("Enter your location pincode");
		int currLocation = read.nextInt();
		
		/* The Math.abs method returns the absolute value 
		 if the value of currLocation - couriers[i] is negative
		 it gives the positive of the same number (-600045 to 600045) */

		int nearestCourierID = 0;
		int minDistance = Math.abs(currLocation - couriers[0]);
		int length = couriers.length;

		for (int i = 0; i < length; i++) {
			int distance = Math.abs(currLocation - couriers[i]);

			if (distance < minDistance) {
				minDistance = distance;
				nearestCourierID = i;
			}
		}
		System.out.println("The nearest available courier is: " + couriers[nearestCourierID]);
	}

	public static void main(String[] args) {
		Task3 t3 = new Task3();
		Scanner read = new Scanner(System.in);
		do {
		System.out.println("Enter Question Number");
		System.out.println(
				"1.Track the location of my package \n" 
		+ "2.Nearest courier branch available \n");
		int questionNumber = read.nextInt();
		switch (questionNumber) {
		case 1:
			t3.trackLocation();
			break;
		case 2:
			t3.nearestCourier();
			break;
		default:
			break;
		}
		}while(true);
	}
}
