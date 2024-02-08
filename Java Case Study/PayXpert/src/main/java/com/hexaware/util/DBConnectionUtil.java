package com.hexaware.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * A class responsible for managing database connection. 
 */
public class DBConnectionUtil {
	
	private static Connection connection;

	/**
	 * A static method for establishing connection.
	 * @return Returns a connection.
	 */
	public static Connection getConnection() {
		try {
	        if (connection == null || connection.isClosed()) {
	            connection = DBPropertyUtil.getPropertyString();
	        }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Checking whether connection is established or not. 
	 * @param args.
	 * @throws SQLException When a problem arises in establishing connection.
	 */
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}

}
