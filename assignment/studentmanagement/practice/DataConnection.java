package com.assignment.studentmanagement.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DataConnection {
	private final static String USERNAME="root";
	private  final static String DATA_BASENAME	="bank_management";
	private  final static String PASSWORD=""	;
	private  final static String DRIVER_NAME="com.mysql.jdbc.Driver";
	private  final static String URL="jdbc:mysql://localhost/";	
	
public static Connection getConnection() throws Exception  {
	Class.forName(DRIVER_NAME);
	return DriverManager.getConnection(URL+DATA_BASENAME, USERNAME,PASSWORD);

	
}
}
/*
 public boolean nameMatch(String name, long accountNumber) {
	    String sqlString = "SELECT * FROM bank WHERE name = ? AND accountnum = ?";
	    try {
	        ps = DataConnection.getConnection().prepareStatement(sqlString);
	        ps.setString(1, name);
	        ps.setLong(2, accountNumber);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	        	JOptionPane.showMessageDialog(null, "Login Successfull");
	        	new  BankDetails();
	            return true;
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return false;
 
*/