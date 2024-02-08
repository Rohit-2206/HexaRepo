package com.hexaware.dao;

import java.sql.SQLException;

import com.hexaware.entity.Courier;
import com.hexaware.exception.TrackingNumberNotFoundException;

public interface ICourierUserService {

	// Task 6 Courier User Service

	public String placeOrder(Courier cr);

	public void courierDetails();

	public String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException, SQLException;

	public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException;

	public void showOrders();

}
