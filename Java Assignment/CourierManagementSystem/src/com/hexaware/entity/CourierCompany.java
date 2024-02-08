package com.hexaware.entity;

import java.util.Arrays;

public class CourierCompany {

	// Task 5.5 Creation of courier company class
	private String companyName;
	private Courier[] courierDetails;
	private Employee[] employeeDetails;
	private Location[] locationDetails;

	public CourierCompany(String companyName, Courier[] courierDetails, Employee[] employeeDetails,
			Location[] locationDetails) {
		this.companyName = companyName;
		this.courierDetails = courierDetails;
		this.employeeDetails = employeeDetails;
		this.locationDetails = locationDetails;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Courier[] getCourierDetails() {
		return courierDetails;
	}

	public void setCourierDetails(Courier[] courierDetails) {
		this.courierDetails = courierDetails;
	}

	public Employee[] getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(Employee[] employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public Location[] getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(Location[] locationDetails) {
		this.locationDetails = locationDetails;
	}

	@Override
	public String toString() {
		return "Courier Company: " + "Company Name: '" + companyName + ", Courier Details: "
				+ Arrays.toString(courierDetails) + ", Employee Details: " + Arrays.toString(employeeDetails)
				+ ", Location Details: " + Arrays.toString(locationDetails);
	}
}
