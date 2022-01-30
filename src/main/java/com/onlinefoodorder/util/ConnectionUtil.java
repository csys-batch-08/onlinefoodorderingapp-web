package com.onlinefoodorder.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil
{
	private ConnectionUtil()
	{
		
	}
	public static Connection getDbConnection() throws ClassNotFoundException, SQLException
	{
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection con = DriverManager.getConnection(url, "system", "oracle");
			return con;
	}
}