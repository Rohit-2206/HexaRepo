package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.entity.Courier;

public class Task4_1 {

	Scanner read = new Scanner(System.in);

	// Task 4 Question 10. Customer Validation

	public void dataValidation() {
		System.out.println("Enter your name");
		String name = read.nextLine();
		System.out.println("Enter your phone number");
		String phone = read.next();
		if (name.matches("^[A-Z][a-z]+(?: [A-Z][a-z]+)?$")) {
			System.out.println("Name Validated and is in correct format");
			if (phone.matches("^\\d{3}-\\d{3}-\\d{4}$")) // 922-902-3392
			{
				System.out.println("Valid Phone Number");
			} else {
				System.out.println("Enter phone number in correct format ###-###-####");
			}
		} else {
			System.out.println("Name not in correct format or contains any special characters");
		}
	}

	// Task 4 Question 15. Find Similar Addresses

	public void similarAddress() {

		String[] address = { "45, Kbm-Vnr Road, Mambakkam, Chennai-603103",
				"VIT University, Kelambakkam - Vandalur Rd, Rajan Nagar, Chennai-600127",
				"3/146, Mettu Street, Payanoor, Mahabalipuram,Chennai-603104",
				"R25J+96X, Kamarajar St, Kattankulathur, Chennai-603203",
				"V2PF+MWF, K.R Puram, Padappai, Chennai-603203" };

		int length = address.length;

		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				String lastI = address[i].substring(address[i].length() - 6);
				String lastJ = address[j].substring(address[j].length() - 6);
				if (lastI.equals(lastJ)) {
					System.out.println("address " + address[i] + " \naddress" + address[j] + " are nearest");
				}

			}
		}
	}

	// Task 4 Question 12 Order Confirmation Email
	public void orderEmail() {
		Courier cr = new Courier();
		System.out.println("Hi " + cr.getSenderName() + " your order with Order ID " + cr.getCourierId()
				+ " has been recieved" + " and is to be sent.You can check the order of your status "
				+ "with the tracking number allocated to you " + cr.getTrackingNumber()
				+ "Your order is expected to be delivered by " + cr.getDeliveryDate() + " Thank You.");
	}

	// Task 4 Question 11 Address Formattig
	public void AddressFormatter() {
		String input = "no:18, rameshwaram road , t-nagar, chennai, 600045";
		String output = capitalizeWords(input);

		System.out.println("Address " + input);
		System.out.println("Result " + output);
	}

	private static String capitalizeWords(String input) {
		String[] words = input.split("\\s+");
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
		}
		return result.toString().trim();
	}

	public static void main(String[] args) {
		Task4_1 t4 = new Task4_1();
		// t4.similarAddress();
		// t4.dataValidation();
		// t4.orderEmail();
		t4.AddressFormatter();
	}
}
