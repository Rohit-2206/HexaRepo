package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;

	public static Connection getConnection() {
		try {
	        if (connection == null || connection.isClosed()) {
	            connection = PropertyUtil.getPropertyString();
	        }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}
