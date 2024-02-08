package com.hexaware.entity;

import java.time.LocalDate;

public class Courier {

	// Task 5.2 Creation of Courier Class
	// Variables -- courierID , senderName ,
	// senderAddress , receiverName , receiverAddress , weight ,
	// status, trackingNumber , deliveryDate ,userId

	private int courierId;
	private String senderName;
	private String senderAddress;
	private String receiverName;
	private String receiverAddress;
	private double weight;
	private String status;
	private String trackingNumber;
	private LocalDate deliveryDate;
	private int userId;
	private int employeeId; // Added it to check which employee is assigned

	public Courier() {

	}

	public Courier(int courierId, String senderName, String senderAddress, String receiverName, String receiverAddress,
			double weight, String status, String trackingNumber, LocalDate deliveryDate, int userId, int employeeId) {
		this.courierId = courierId;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.weight = weight;
		this.status = status;
		this.trackingNumber = trackingNumber;
		this.deliveryDate = deliveryDate;
		this.userId = userId;
		this.employeeId = employeeId;
	}

	public int getCourierId() {
		return courierId;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public double getWeight() {
		return weight;
	}

	public String getStatus() {
		return status;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String toString() {
		return "CourierDetails:" + "CourierID: " + courierId + ", Sender Name: " + senderName + ", SenderAddress: "
				+ senderAddress + ", Receiver Name: " + receiverName + ", ReceiverAddress: " + receiverAddress
				+ ", Weight: " + weight + ", Tracking Number: " + trackingNumber + ", Delivery Status: " + status
				+ ", Delivery Date: " + deliveryDate + ", User ID: " + userId + ", Employee Assigned: " + employeeId;
	}
}
