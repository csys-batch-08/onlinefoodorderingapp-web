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
	public void insertRestaurantDetails(RestaurantDetails restaurant)
	{
		String insertQuery = "insert into restaurant_details(restaurant_name, area, city, pincode, restaurant_landline_no, owner_name, operational_hours, email, password, restaurant_image) values(?,?,?,?,?,?,?,?,?,?)";
		ConnectionUtil con = new ConnectionUtil();
		Connection c1 = con.getDbConnection();
		PreparedStatement p1 = null;
		
		try {
			p1 = c1.prepareStatement(insertQuery);
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
		}
	}
	public void restaurantUpdate(RestaurantDetails restaurant)
	{
		String updateQuery = "update restaurant_details set restaurant_name=?, restaurant_landline_no=?, owner_name=?, operational_hours=?, password=? where email=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(updateQuery);
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
		 }
		
	}
	
	public void inactiveRestaurant(String emailid)
	{
		String updateQuery = "update restaurant_details set restaurant_status = 'Inactive' where email =?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(updateQuery);
			p1.setString(1, emailid);
			int i = p1.executeUpdate();
			p1.executeUpdate("commit");
			System.out.println(i+ "restaurant deleted");
			p1.close();
			con.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void activeRestaurant(String emailid)
	{
		String updateQuery = "update restaurant_details set restaurant_status = 'active' where email =?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(updateQuery);
			p1.setString(1, emailid);
			int i = p1.executeUpdate();
			p1.executeUpdate("commit");
			System.out.println(i+ "restaurant deleted");
			p1.close();
			con.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public int findRestaurantId(String email)
	{
		String findid = "select restaurant_id from restaurant_details where email='"+email+"'";
		Connection con = ConnectionUtil.getDbConnection();
		Statement s1= null; 
		int restaurantid = 0;
		try {
			s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(findid);
			if(rs.next())
			{
				restaurantid = rs.getInt(1);
				System.out.println("resid" +restaurantid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantid;
	}
	
	public int findRestaurantId2(String restaurantName)
	{
		System.out.println(restaurantName + "resname");
		String findId = "select restaurant_id from restaurant_details where restaurant_name='"+restaurantName+"'";
		Connection con = ConnectionUtil.getDbConnection();
		int restaurantId = 0;
		try {
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(findId);
			if(rs.next())
			{
				restaurantId = rs.getInt(1);
				System.out.println(restaurantId + "ridfind");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return restaurantId;
	}
	public String findRestaurantName(int restaurantId)
	{
		String findname = "select restaurant_name from restaurant_details where restaurant_id='"+restaurantId+"'";
		Connection con = ConnectionUtil.getDbConnection();
		String restaurantname = null;
		try {
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(findname);
			if(rs.next())
			{
				restaurantname = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return restaurantname;
	}
	
	
	
	//restaurant max(id):
	
	public int findmaxresid() {
		String findId = "select max(restaurant_id) from restaurant_details";
		Connection con = ConnectionUtil.getDbConnection();
		int restaurantId = -1;
		try {
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(findId);
			if(rs.next())
			{
				restaurantId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return restaurantId;
	}
	
	public List<RestaurantDetails> showRestaurant()
	{
		List<RestaurantDetails> restaurantlist = new ArrayList<RestaurantDetails>();
		String query = "select * from restaurant_details where restaurant_status='active'";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement p1 = con.createStatement();
			ResultSet rs = p1.executeQuery(query); 
			while(rs.next())
			{
				RestaurantDetails restaurant = new RestaurantDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
				restaurantlist.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantlist;
	}
	
	public List<RestaurantDetails> filterbyCity(String city)
	{
		List<RestaurantDetails> restaurantlist = new ArrayList<RestaurantDetails>();
		String query = "select * from restaurant_details where city= ?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(query);
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
		}
 		return restaurantlist;
	}
	@Override
	public void restaurantUpdate(String email, String password) {
	}
	@Override
	public void deleteRestaurant(String email) {
		
	}
		
	
}








