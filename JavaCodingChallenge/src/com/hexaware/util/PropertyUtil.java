package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PropertyUtil {
	
	public static Connection getPropertyString() {
		
		/* String fileName = "db.properties";
		Properties props = new Properties();
		FileInputStream fis =null;
		
		try {
			fis = new FileInputStream(fileName);
			props.load(fis);
			
			String url = props.getProperty("db.url");
			String un = props.getProperty("db.username");
			String pwd = props.getProperty("db.password");
	        return url + "?user=" + un + "&password=" + pwd;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;*/
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
