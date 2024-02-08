package com.hexaware.controller;

import com.hexaware.dao.CourierServiceDb;
import com.hexaware.dao.ICourierUserService;
import com.hexaware.entity.Courier;
import com.hexaware.entity.CourierCompany;
import com.hexaware.exception.TrackingNumberNotFoundException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CourierUserServiceImpl implements ICourierUserService {

	// Task 6 Courier User Service
	
    @SuppressWarnings("unused")
	private CourierCompany companyObj;
	LocalDate ldt = LocalDate.now();
	CourierServiceDb crdb = new CourierServiceDb();
	private static List<Courier> courierList = new ArrayList<Courier>();
	Courier cr;
	Scanner sc = new Scanner(System.in);
	
    public CourierUserServiceImpl(CourierCompany companyObj) {
        this.companyObj = companyObj;
    }
    /**
     * 
     * This method is used to get details of a customer to place a new order
     * 
     * */
	public String placeOrder(Courier cr) {

		cr = new Courier();

		int courierId = generateRandom();
		cr.setCourierId(courierId);

		System.out.println("Enter your Name");
		String senderName = sc.next();
		cr.setSenderName(senderName);

		System.out.println("Enter your Address");
		String senderAddress = sc.next();
		cr.setSenderAddress(senderAddress);

		System.out.println("Enter Receiver Name");
		String receiverName = sc.next();
		cr.setReceiverName(receiverName);

		System.out.println("Enter Receiver Address");
		String receiverAddress = sc.next();
		cr.setReceiverAddress(receiverAddress);

		String status = "Yet to Transit";
		cr.setStatus(status);

		String trackingNumber = trackingNumberGenerator();
		cr.setTrackingNumber(trackingNumber);

		System.out.println("Enter userID");
		int userId = sc.nextInt();
		cr.setUserId(userId);

		LocalDate deliveryDate = ldt.plusDays(7);
		cr.setDeliveryDate(deliveryDate);

		System.out.println("Enter courier weight");
		double weight = sc.nextDouble();
		cr.setWeight(weight);

		int employeeId = random();
		cr.setEmployeeId(employeeId);

		courierList.add(cr);

		crdb.placeOrder(cr);

		System.out.println("Courier " + cr.getCourierId() + " added Successfully !!!");
		System.out.println("Your tracking number is " + cr.getTrackingNumber());
		return trackingNumber;
	}

	/**
	 * 
	 * Generate a unique tracking number which is mixture all characters and numbers 
	 * 
	 * */
	private String trackingNumberGenerator() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder s = new StringBuilder(7);
		for (int y = 0; y < 7; y++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			s.append(AlphaNumericString.charAt(index));
		}
		return s.toString();
	}

	private int random() {
		Random random = new Random();
		int rand = random.nextInt(6) + 1;
		;
		return rand;
	}

	private int generateRandom() {
		Random random = new Random();
		int rand = Math.abs(random.nextInt());
		return rand;
	}

	public void courierDetails() {
		System.out.println(
				"Your order has been placed. " + "Your tracking number for the order is " + cr.getTrackingNumber());
		System.out.println("Details: " + courierList);
	}

	public String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException, SQLException {
		CourierServiceDb crdb = new CourierServiceDb();
		System.out.println("Enter tracking Number");
		String number = sc.next();

		try {
			String status = crdb.orderStatus(number);

			if (status != null) {
				System.out.println("Status: " + status);
				return status;
			} else {
				throw new TrackingNumberNotFoundException();
			}
		} catch (TrackingNumberNotFoundException e) {
			System.out.println(e.getMessage());
            return null;
		}
		
	}

	public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
		CourierServiceDb crdb = new CourierServiceDb();
		System.out.println("enter your unique Tracking Number");
		String id = sc.next();
		if (crdb.deleteCourier(id)) {
			System.out.println("Order canceled successfully.");
			
		}
		return true;
	}

	public void showOrders() {
		CourierServiceDb crdb = new CourierServiceDb();
		System.out.println("Enter your User ID");
		int userId = sc.nextInt();

		System.out.println(crdb.showOrderForCustomer(userId));

	}

	// Get Assigned Order is available in CourierAdminServiceImpl
	// as it is a admin servive using Staff ID
}

