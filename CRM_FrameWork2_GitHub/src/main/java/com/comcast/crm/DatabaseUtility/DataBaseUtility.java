package com.comcast.crm.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	
	public void getDbConnnection(String url, String username , String password) throws SQLException 
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url, username,password);
	}
	public void closeDbConnection() throws SQLException 
	{
	
		conn.close();
	}
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		Statement stat = conn.createStatement();
		ResultSet res = stat.executeQuery(query);
		return res;
	}
	public int executeNonSelectQuery(String query) throws SQLException
	{
		Statement stat = conn.createStatement();
		int ins = stat.executeUpdate(query);
		return ins;
		
	}
}
