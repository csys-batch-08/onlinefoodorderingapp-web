package com.onlinefoodorder.daoimpl;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodorder.dao.RestaurantdetailsDao;
import com.foodorder.util.ConnectionUtil;
import com.onlinefoodorder.model.RestaurantDetails;

public class RestaurantdetailsDaoimpl implements RestaurantdetailsDao
{
	public void insertRestaurantDetails(RestaurantDetails restaurant) throws SQLException
	{
		String insertQuery = "insert into restaurant_details(restaurant_name, area, city, pincode, restaurant_landline_no, owner_name, operational_hours, email, password, restaurant_image) values(?,?,?,?,?,?,?,?,?,?)";
		ConnectionUtil con1 = new ConnectionUtil();
		Connection con = con1.getDbConnection();
		PreparedStatement p1 = null;
		
		try {
			p1 = con.prepareStatement(insertQuery);
			p1.setString(1, restaurant.getRestaurantName());
			p1.setString(2, restaurant.getArea());
			p1.setString(3, restaurant.getCity());
			p1.setInt(4, restaurant.getPincode());
			p1.setLong(5, restaurant.getRestaurantLandlineNo());
			p1.setString(6, restaurant.getOwnerName());
			p1.setString(7, restaurant.getOperationalHours());
			p1.setString(8, restaurant.getEmail());
			p1.setString(9, restaurant.getPassword());
			p1.setString(10, restaurant.getRestaurantImages());
			p1.executeUpdate();
			System.out.println("Restaurant details are inserted");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println("Try again");
		}finally {
			if(p1!=null) {
				p1.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	public void restaurantUpdate(RestaurantDetails restaurant) throws SQLException
	{
		String updateQuery = "update restaurant_details set restaurant_name=?, restaurant_landline_no=?, owner_name=?, operational_hours=?, password=? where email=?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement p1=null;
		try {
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, restaurant.getRestaurantName());
			p1.setLong(2, restaurant.getRestaurantLandlineNo());
			p1.setString(3, restaurant.getOwnerName());
			p1.setString(4, restaurant.getOperationalHours());
			p1.setString(5, restaurant.getPassword());
			p1.setString(6, restaurant.getEmail());
			int i = p1.executeUpdate();
			p1.executeUpdate("commit");
			System.out.println(i+" restaurant details updated");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		 }finally {
			if(p1!=null) {
				p1.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
	}
	
	public void inactiveRestaurant(String emailid) throws SQLException
	{
		String updateQuery = "update restaurant_details set restaurant_status = 'Inactive' where email = ?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement p1=null;
		try {
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, emailid);
			int i = p1.executeUpdate();
			p1.executeUpdate("commit");
			System.out.println(i+ "restaurant deleted");
			p1.close();
			con.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
			if(p1!=null) {
				p1.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	
	public void activeRestaurant(String emailid) throws SQLException
	{
		String updateQuery = "update restaurant_details set restaurant_status = 'active' where email =?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement p1=null;
		try {
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, emailid);
			int i = p1.executeUpdate();
			p1.executeUpdate("commit");
			System.out.println(i+ "restaurant deleted");
			p1.close();
			con.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
			if(p1!=null) {
				p1.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	
	public int findRestaurantId(String email) throws SQLException
	{
		String findid = "select restaurant_id from restaurant_details where email='"+email+"'";
		Connection con = ConnectionUtil.getDbConnection();
		Statement statement= null; 
		int restaurantid = 0;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(findid);
			if(rs.next())
			{
				restaurantid = rs.getInt(1);
				System.out.println("resid" +restaurantid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return restaurantid;
	}
	
	public int findRestaurantId2(String restaurantName) throws SQLException
	{
		System.out.println(restaurantName + "resname");
		String findId = "select restaurant_id from restaurant_details where restaurant_name='"+restaurantName+"'";
		Connection con = ConnectionUtil.getDbConnection();
		int restaurantId = 0;
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(findId);
			if(rs.next())
			{
				restaurantId = rs.getInt(1);
				System.out.println(restaurantId + "ridfind");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
		return restaurantId;
	}
	
	public String findRestaurantName(int restaurantId) throws SQLException
	{
		String findname = "select restaurant_name from restaurant_details where restaurant_id='"+restaurantId+"'";
		Connection con = ConnectionUtil.getDbConnection();
		String restaurantname = null;
		Statement statement=null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(findname);
			if(rs.next())
			{
				restaurantname = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
		return restaurantname;
	}
	
	public int findmaxresid() throws SQLException {
		String findId = "select max(restaurant_id) from restaurant_details";
		Connection con = ConnectionUtil.getDbConnection();
		int restaurantId = -1;
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(findId);
			if(rs.next())
			{
				restaurantId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
		return restaurantId;
	}
	
	public List<RestaurantDetails> showRestaurant() throws SQLException
	{
		List<RestaurantDetails> restaurantlist = new ArrayList<RestaurantDetails>();
		String query = "select * from restaurant_details where restaurant_status='active'";
		Connection con = ConnectionUtil.getDbConnection();
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query); 
			while(rs.next())
			{
				RestaurantDetails restaurant = new RestaurantDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
				restaurantlist.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return restaurantlist;
	}
	
	public List<RestaurantDetails> filterbyCity(String city) throws SQLException
	{
		List<RestaurantDetails> restaurantlist = new ArrayList<RestaurantDetails>();
		String query = "select * from restaurant_details where city= ?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement p1 = null;
		try {
			p1 = con.prepareStatement(query);
			p1.setString(1, city);
			ResultSet rs = p1.executeQuery();
			p1.executeUpdate("commit");
			while(rs.next())
			{
				RestaurantDetails restaurant = new RestaurantDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
				restaurantlist.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(p1!=null) {
				p1.close();
			}
			if(con!=null) {
				con.close();
			}
		}
 		return restaurantlist;
	}	
}







