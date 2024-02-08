package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A class for reading URL , USername and PAAssword from the file.
 */
public class DBPropertyUtil {
	
	/**
	 * Reads the file and returns a connection.
	 * @return Returns a connection.
	 */
	public static Connection getPropertyString() {
	
	Connection connection = null;
	String fileName = "db.properties";
	Properties props = new Properties();
	FileInputStream fis =null;
	
	try {
		fis = new FileInputStream(fileName);
		props.load(fis);
		
		String url = props.getProperty("db.url");
		String un = props.getProperty("db.username");
		String pass = props.getProperty("db.password");
		try {
			connection = DriverManager.getConnection(url, un, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	return connection;	
}

}
