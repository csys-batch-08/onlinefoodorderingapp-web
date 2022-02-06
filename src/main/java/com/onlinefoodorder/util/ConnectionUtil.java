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
		super();
	}
	public static Connection getDbConnection(){
			Connection con=null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				con = DriverManager.getConnection(url, "system", "oracle");
			} catch (ClassNotFoundException | SQLException e) {
				e.getMessage();
			}
			return con;
	}
	public static void closeConnectionStatementResultSet(ResultSet rs, PreparedStatement p1, Connection con)
	{
		try {
			if(rs != null) {
				rs.close();
			} 
			if(con != null) {
				con.close();
			}
			if(p1 != null) {
				p1.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnectionStatement(PreparedStatement p1, Connection con)
	{
		try { 
			if(p1 != null) {
				p1.close();
			}
			if(con != null) {
				con.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}