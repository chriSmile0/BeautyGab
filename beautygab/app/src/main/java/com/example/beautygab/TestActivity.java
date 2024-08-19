package com.example.beautygab;

import java.sql.DriverManager;
import java.sql.Connection;

// Main Activity implements Adapter view
public class TestActivity  {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/beautygab_db";
		String username = "root";
		String password = "";
		try {
			// Load the MySQL JDBC driver
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,username,password);
			System.out.println("MySQL JDBC driver loaded ok.");

		} catch (Exception e) {
			System.err.println("Exception: "+e.getMessage());
		}
	}
}