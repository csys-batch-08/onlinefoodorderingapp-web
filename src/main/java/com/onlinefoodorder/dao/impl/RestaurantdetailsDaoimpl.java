package com.onlinefoodorder.dao.impl;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinefoodorder.dao.RestaurantdetailsDao;
import com.onlinefoodorder.model.RestaurantDetails;
import com.onlinefoodorder.util.ConnectionUtil;

public class RestaurantdetailsDaoimpl implements RestaurantdetailsDao
{
	//Insert Restaurant Details
	
	public void insertRestaurantDetails(RestaurantDetails restaurant) throws SQLException
	{
		String insertQuery = "insert into restaurant_details(restaurant_name, area, city, pincode, restaurant_landline_no, owner_name, operational_hours, email, password, restaurant_image) values(?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement p1 = null;
		
		try {
			con = ConnectionUtil.getDbConnection();
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
		} 
		catch (SQLException e) 
		{
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
	
	//Update Restaurant Details
	
	public void restaurantUpdate(RestaurantDetails restaurant) throws SQLException
	{
		String updateQuery = "update restaurant_details set restaurant_name=?, restaurant_landline_no=?, owner_name=?, operational_hours=?, password=? where email=?";
		Connection con = null;
		PreparedStatement p1=null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, restaurant.getRestaurantName());
			p1.setLong(2, restaurant.getRestaurantLandlineNo());
			p1.setString(3, restaurant.getOwnerName());
			p1.setString(4, restaurant.getOperationalHours());
			p1.setString(5, restaurant.getPassword());
			p1.setString(6, restaurant.getEmail());
			p1.executeUpdate();
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
	
	//Inactive Restaurant
	
	public int inactiveRestaurant(String emailid) throws SQLException
	{
		String updateQuery = "update restaurant_details set restaurant_status = 'Inactive' where email = ?";
		Connection con = null;
		PreparedStatement p1=null;
		int i = -1;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, emailid);
			 i = p1.executeUpdate();
		
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
		return i;
	}
	
	//Active Restaurant
	
	public void activeRestaurant(String emailid) throws SQLException
	{
		String updateQuery = "update restaurant_details set restaurant_status = 'active' where email =?";
		Connection con = null;
		PreparedStatement p1=null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, emailid);
			p1.executeUpdate();
			p1.executeUpdate("commit");
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
	
	//Find Restaurant Id
	
	public int findRestaurantId(String email) throws SQLException
	{
		String findid = "select restaurant_id from restaurant_details where email='"+email+"'";
		Connection con = null;
		Statement statement= null; 
		int restaurantid = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(findid);
			if(rs.next())
			{
				restaurantid = rs.getInt(1);
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
	
	// Find Restaurant Name
	
	public String findRestaurantName(String email) throws SQLException
	{
		String findName = "select restaurant_name from restaurant_details where email='"+email+"'";
		Connection con = null;
		Statement statement= null; 
		String restaurantName = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(findName);
			if(rs.next())
			{
				restaurantName = rs.getString(1);
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
		return restaurantName;
	}
	
	//Find Restaurant Id through restaurant name
	
	public int findRestaurantId2(String restaurantName) throws SQLException
	{
		String findId = "select restaurant_id from restaurant_details where restaurant_name='"+restaurantName+"'";
		Connection con = null;
		int restaurantId = 0;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
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
	
	// Find Restaurant Name through RestaurantId
	
	public String findRestaurantName(int restaurantId) throws SQLException
	{
		String findname = "select restaurant_name from restaurant_details where restaurant_id='"+restaurantId+"'";
		Connection con = null;
		String restaurantname = null;
		Statement statement=null;
		try {
			con = ConnectionUtil.getDbConnection();
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
	
	// User view all restaurant
	
	public List<RestaurantDetails> showRestaurant() throws SQLException
	{
		List<RestaurantDetails> restaurantlist = new ArrayList<>();
		String query = "select restaurant_id, restaurant_name, area, city, pincode, restaurant_landline_no, owner_name, operational_hours, email, password, restaurant_image, restaurant_status from restaurant_details where restaurant_status='active'";
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query); 
			while(rs.next())
			{
				RestaurantDetails restaurant = new RestaurantDetails(rs.getInt("restaurant_id"), rs.getString("restaurant_name"), rs.getString("area"), rs.getString("city"), rs.getInt("pincode"), rs.getLong("restaurant_landline_no"), rs.getString("owner_name"), rs.getString("operational_hours"), rs.getString("email"), rs.getString("password"), rs.getString("restaurant_image"), rs.getString("restaurant_status"));
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
	
	// Filter Restaurants by cityname
	
	public List<RestaurantDetails> filterbyCity(String city) throws SQLException
	{
		List<RestaurantDetails> restaurantlist = new ArrayList<>();
		String query = "select restaurant_id, restaurant_name, area, city, pincode, restaurant_landline_no, owner_name, operational_hours, email, password, restaurant_image, restaurant_status from restaurant_details where city= ?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setString(1, city);
			ResultSet resultSet = p1.executeQuery();
			while(resultSet.next())
			{
				RestaurantDetails restaurant = new RestaurantDetails(resultSet.getString("restaurant_name"), resultSet.getString("area"), resultSet.getString("city"), resultSet.getInt("pincode"), resultSet.getLong("restaurant_landline_no"), resultSet.getString("owner_name"), resultSet.getString("operational_hours"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("restaurant_image"));
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








