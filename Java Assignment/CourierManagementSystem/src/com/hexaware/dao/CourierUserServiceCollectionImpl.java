package com.hexaware.dao;

import com.hexaware.entity.Courier;
import com.hexaware.entity.CourierCompanyCollection;

// Task 8.2 Courier User Service Collection Implementation

public class CourierUserServiceCollectionImpl implements ICourierUserService {

	private CourierCompanyCollection companyObj;

	public CourierUserServiceCollectionImpl(CourierCompanyCollection companyObj) {
		super();
		this.companyObj = companyObj;
	}

	public CourierCompanyCollection getCompanyObj() {
		return companyObj;
	}

	public void setCompanyObj(CourierCompanyCollection companyObj) {
		this.companyObj = companyObj;
	}

	public void placeOrder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void courierDetails() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getOrderStatus(String trackingNumber) {
		return trackingNumber;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean cancelOrder(String trackingNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showOrders() {
		// TODO Auto-generated method stub
	}

	@Override
	public String placeOrder(Courier cr) {
		return cr.getTrackingNumber();
		// TODO Auto-generated method stub

	}

}
