package com.cts.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;


@Component
public class JdbcConnector {

	
	
	public final static String userName="root";
	public final static String password="root";
	public final static String url="jdbc:mysql://localhost:3306/bookmanagement";
	public final static String driverName="com.mysql.jdbc.Driver"; 
	public static Connection getConnection(){
		Connection connection=null;
		try{
		Class.forName(driverName);
		connection= DriverManager.getConnection(url,userName,password);
		return connection;
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	return null;
	}
	
	public static void closeConnection(Connection connection)
	
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	    /*public static Connection getConnection(){
	     
	    	 Class.forName("com.mysql.jdbc.Driver"); 
	    	  Connection con = 
	         DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmanagement","root","root");
	   
	        return con;
	    }
	    */
	    
	
}
