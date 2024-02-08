package com.hexaware.entity;

import java.util.Date;

public class Payment {

	// Task 5.6 Creation of Payment Class
	// Variables PaymentID long, CourierID long,
	// Amount double, PaymentDate Date

	private int paymentId;
	private int courierId;
	private double amount;
	private Date paymentDate;

	public Payment() {

	}

	public Payment(int paymentId, int courierId, double amount, Date paymentDate) {
		this.paymentId = paymentId;
		this.courierId = courierId;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getCourierId() {
		return courierId;
	}

	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String toString() {
		return "Payment Details" + "Payment ID: " + paymentId + "CourierID: " + courierId + "Amount Paid: " + amount
				+ "Payment Date: " + paymentDate;
	}

}
