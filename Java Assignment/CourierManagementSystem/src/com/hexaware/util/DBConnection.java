package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// Task 9.1 Establishing connection to Database

	static Connection connection;

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/courier_management_system", "root",
					"W7301@jqir#");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		System.out.println(getConnection());

	}

}
