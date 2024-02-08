package com.hexaware.entity;

public class User {

	// Task 5.1 Creating user class
	private int userId;
	private String userName;
	private String emailId;
	private String password;
	private String contactNumber;
	private String address;

	public User() {
	}

	public User(int userId, String userName, String emailId, String password, String contactNumber, String address) {
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public int getUserID() {
		return userId;
	}

	public void setUserID(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmail(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDetails: " + "UserID=" + userId + ", User Name ='" + userName + ", EmailID ='" + emailId
				+ ", Password ='" + password + ", Contact Number = " + contactNumber + ", Address ='" + address;
	}
}
