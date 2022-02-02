package com.onlinefoodorder.dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinefoodorder.dao.FoodItemsDao;
import com.onlinefoodorder.model.FoodItems;
import com.onlinefoodorder.util.ConnectionUtil;

public class FoodItemsDaoimpl implements FoodItemsDao
{
	//Admin Insert food items
	
	public void insertFoodItems(FoodItems fooditem) throws SQLException
	{
		String insertQuery = "insert into food_items(restaurant_id, food_name, cuisine_name, description, price, food_image)values(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(insertQuery);
			p1.setInt(1, fooditem.getRestaurantId());
			p1.setString(2, fooditem.getFoodName());
			p1.setString(3, fooditem.getCuisineName());
			p1.setString(4, fooditem.getDescription());
			p1.setDouble(5, fooditem.getPrice());
			p1.setString(6, fooditem.getFoodImage());
			p1.executeUpdate();
			p1.executeUpdate("commit");
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
	
	//user view foodlist by restaurant   
	
	public List<FoodItems> showFoodsbyRestaurant(int restaurantid) throws SQLException
	{
		List<FoodItems> foodnamelist = new ArrayList<>();
		String query = "select restaurant_id, item_id, food_name, cuisine_name, description, price, food_image, food_status from food_items where restaurant_id = ?";
		Connection con = null;
		RestaurantdetailsDaoimpl restaurantdao= new RestaurantdetailsDaoimpl();
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, restaurantid);
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				String resName = restaurantdao.findRestaurantName(rs.getInt(1));
				FoodItems fooditem = new FoodItems(rs.getInt("restaurant_id"),rs.getInt("item_id"),rs.getString("food_name"), rs.getString("cuisine_name"), rs.getString("description"),rs.getDouble("price"), rs.getString("food_image"),resName);
				foodnamelist.add(fooditem);
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
		return foodnamelist;
	}
	
	//User View all food items
	
	public List<FoodItems> showFoodItems() throws SQLException
	{
		List<FoodItems> foodItemList = new ArrayList<>();
		String showQuery = "select restaurant_id, item_id, food_name, cuisine_name, description, price, food_image, food_status from food_items";
		Connection con = null;
		RestaurantdetailsDaoimpl restaurantdao= new RestaurantdetailsDaoimpl();
		Statement statement = null;
		try {
				con = ConnectionUtil.getDbConnection();
				statement = con.createStatement();
				ResultSet rs =statement.executeQuery(showQuery);
				while(rs.next())
				{
					String resName = restaurantdao.findRestaurantName(rs.getInt(1));
					FoodItems fooditem = new FoodItems(rs.getInt("restaurant_id"),rs.getInt("item_id"),rs.getString("food_name"), rs.getString("cuisine_name"), rs.getString("description"),rs.getDouble("price"), rs.getString("food_image"),resName);
					foodItemList.add(fooditem);
				}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return foodItemList;
	}
	
	//Find food name through RestaurantId
	
	public List<FoodItems> findfoodNames(int resid) throws SQLException
	{
		List<FoodItems> foodnamelist = new ArrayList<>();
		String query = "select food_name, price, foodimages from food_items where restaurant_id = "+resid;
		Connection con = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next())
			{
				FoodItems fooditem = new FoodItems(resid, rs.getString("food_name"), rs.getString("cuisine_name"), rs.getString("description"),rs.getDouble("price"), rs.getString("food_image"));
				foodnamelist.add(fooditem);
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
		return foodnamelist;	
	}

	//Find Food Name through FoodId
	
	public String findFoodname(int foodid) throws SQLException
	{
		String findname = "select food_name from food_items where food_name = '"+foodid+"'";
		Connection con = null;
		String itemname = null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(findname);
			if(rs.next())
			{
				itemname = rs.getString(1);
			}
		} 
		catch (SQLException e) {
				e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return itemname;
	}
	
	//Find Food Price
	
	public int findFoodPrice(int foodid) throws SQLException
	{
		String price ="select price from food_items where item_id= '"+foodid+"'";
		Connection con = null;
		Statement statement = null;
		int foodprice = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			statement=con.createStatement();
			ResultSet rs = statement.executeQuery(price);
			if(rs.next())
			{
				foodprice = rs.getInt(1);
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
		return foodprice;			
	}
		
	// Find ItemId 
	
	public int finditemid(String foodname, int restaurantid) throws SQLException
	{
		String price ="select item_id from food_items where restaurant_id = ? and food_name = ?";
		Connection con = null;
		PreparedStatement p1=null;
		
		try {
			con = ConnectionUtil.getDbConnection();
			p1=con.prepareStatement(price);
			p1.setInt(1, restaurantid);
			p1.setString(2, foodname);
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
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
		return -1;
	}
	
	// Filter Foods by food name 
	
	public List<FoodItems> filterbyfoodname(String foodname) throws SQLException
	{
		List<FoodItems> foodnamelist = new ArrayList<>();
		String query = "select restaurant_id, item_id, food_name, cuisine_name, description, price, food_image, food_status from food_items where food_name=?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setString(1, foodname);
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				FoodItems fooditem = new FoodItems(rs.getInt("restaurant_id"), rs.getString("food_name"), rs.getString("cuisine_name"), rs.getString("description"), rs.getDouble("price"), rs.getString("food_image"));
				foodnamelist.add(fooditem);
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
		return foodnamelist;
	}	
	
}
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		