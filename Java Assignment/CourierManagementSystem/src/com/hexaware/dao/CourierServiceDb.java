package com.hexaware.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.entity.Courier;
import com.hexaware.entity.Employee;
import com.hexaware.exception.InvalidEmployeeIDException;
import com.hexaware.exception.TrackingNumberNotFoundException;
import com.hexaware.util.DBConnection;

public class CourierServiceDb {

	// Task 9.2

	Connection connection;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;

	public CourierServiceDb() {
		connection = DBConnection.getConnection();
	}

	public void addEmployee(Employee emp) {
		try {
			ps = connection.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			ps.setInt(1, emp.getEmployeeId());
			ps.setString(2, emp.getEmployeeName());
			ps.setString(3, emp.getEmailId());
			ps.setString(4, emp.getContactNumber());
			ps.setString(5, emp.getRole());
			ps.setDouble(6, emp.getSalary());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void showEmployee() {
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from employee");
			while (rs.next()) {
				System.out.println("***************");
				System.out.println("EmployeeID: " + rs.getInt(1));
				System.out.println("Ename: " + rs.getString(2));
				System.out.println("EmailID: " + rs.getString(3));
				System.out.println("Contact Number: " + rs.getString(4));
				System.out.println("Role: " + rs.getString(5));
				System.out.println("Salary: " + rs.getDouble(6));
				System.out.println("***************");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void placeOrder(Courier cr) {
		try {
			ps = connection.prepareStatement("insert into couriers values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, cr.getCourierId());
			ps.setString(2, cr.getSenderName());
			ps.setString(3, cr.getSenderAddress());
			ps.setString(4, cr.getReceiverName());
			ps.setString(5, cr.getReceiverAddress());
			ps.setDouble(6, cr.getWeight());
			ps.setString(7, cr.getStatus());
			ps.setString(8, cr.getTrackingNumber());
			ps.setString(9, cr.getDeliveryDate().toString());
			ps.setInt(10, cr.getUserId());
			ps.setInt(11, cr.getEmployeeId());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully !!!");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public String orderStatus(String trackingNumber) throws SQLException {
		Courier cr = new Courier();
		try {
			stmt = connection.createStatement();
			ps = connection.prepareStatement("SELECT status FROM couriers WHERE trackingnumber = ?");

			ps.setString(1, trackingNumber);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getString("status");
			} else {
				throw new TrackingNumberNotFoundException();
			}
		} catch (TrackingNumberNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return "";
	}

	public boolean deleteCourier(String trackingNumber) throws TrackingNumberNotFoundException {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE " + "FROM Couriers WHERE trackingnumber = ?");
			{

				ps.setString(1, trackingNumber);
				int noofrows = ps.executeUpdate();

				if (noofrows > 0) {
					System.out.println(noofrows + "Courier deleted");
					return true;
				} else {
					throw new TrackingNumberNotFoundException();
				}

			}
		} catch (TrackingNumberNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}

	public void viewAllOrders() {
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from couriers");

			while (rs.next()) {
				System.out.println("***************");
				System.out.println("OrderID : " + rs.getInt(1));
				System.out.println("Sender Name : " + rs.getString(2));
				System.out.println("Sender Address : " + rs.getString(3));
				System.out.println("Receiver Name : " + rs.getString(4));
				System.out.println("Receiver Address : " + rs.getString(5));
				System.out.println("Weight : " + rs.getDouble(6));
				System.out.println("Order Status : " + rs.getString(7));
				System.out.println("Tracking Number : " + rs.getString(8));
				System.out.println("Delivery Date : " + rs.getString(9));
				System.out.println("User ID : " + rs.getString(10));
				System.out.println("***************");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public String showOrderForCustomer(int userId) {

		try {
			PreparedStatement ps = connection.prepareStatement("select * from couriers where userid = ?");

			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("***************");
				System.out.println("OrderID : " + rs.getInt(1));
				System.out.println("Sender Name : " + rs.getString(2));
				System.out.println("Sender Address : " + rs.getString(3));
				System.out.println("Receiver Name : " + rs.getString(4));
				System.out.println("Receiver Address : " + rs.getString(5));
				System.out.println("Weight : " + rs.getDouble(6));
				System.out.println("Order Status : " + rs.getString(7));
				System.out.println("Tracking Number : " + rs.getString(8));
				System.out.println("Delivery Date : " + rs.getString(9));
				System.out.println("User ID : " + rs.getString(10));
				System.out.println("***************");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "Orders placed by customer with User ID " + userId;
	}

	public String showAssignedOrders(int staffId) throws InvalidEmployeeIDException {

		try {
			PreparedStatement ps = connection.prepareStatement("select * from couriers where employeeid = ?");

			ps.setInt(1, staffId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			while (rs.next()) {
				System.out.println("***************");
				System.out.println("OrderID : " + rs.getInt(1));
				System.out.println("Sender Name : " + rs.getString(2));
				System.out.println("Sender Address : " + rs.getString(3));
				System.out.println("Receiver Name : " + rs.getString(4));
				System.out.println("Receiver Address : " + rs.getString(5));
				System.out.println("Weight : " + rs.getDouble(6));
				System.out.println("Order Status : " + rs.getString(7));
				System.out.println("Tracking Number : " + rs.getString(8));
				System.out.println("Delivery Date : " + rs.getString(9));
				System.out.println("User ID : " + rs.getString(10));
				System.out.println("***************");
				}
			}else {
				throw new InvalidEmployeeIDException();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}return"";
	}

	public String reportGeneration() {

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT userid, COUNT(*) as totalOrders FROM couriers GROUP BY userid");

			while (rs.next()) {
				String userId = rs.getString("userid");
				int totalOrders = rs.getInt("totalOrders");

				System.out.println("User ID: " + userId);
				System.out.println("Total Orders Placed: " + totalOrders);
				System.out.println("***************");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "";
	}
}