package com.tap.utility;
// Business Logic

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/food_delivery";
	private static final String username = "root";
	private static final String password = "samroot";
	
	private static Connection con = null;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,username,password);
			System.out.println("Connection created...");
			
		}
		catch(Exception e) { //ClassNotFoundException  | SQLException 
			e.printStackTrace();
		}
		return con;
	}
}
