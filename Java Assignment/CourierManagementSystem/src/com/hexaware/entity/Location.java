package com.hexaware.entity;

public class Location {

	// Task 5.4 Creation of Location Class
	// Variables LocationID , LocationName , Address

	private int locationId;
	private String locationName;
	private String address;

	public Location() {

	}

	public Location(int locationId, String locationName, String address) {
		this.locationId = locationId;
		this.locationName = locationName;
		this.address = address;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "Location Details: " + "LocationID: " + locationId + ", Location Name: " + locationName + ", Address: "
				+ address;
	}

}
