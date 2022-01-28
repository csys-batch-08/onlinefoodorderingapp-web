package com.onlinefoodorder.daoimpl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodorder.dao.FoodItemsDao;
import com.foodorder.util.ConnectionUtil;
import com.onlinefoodorder.model.FoodItems;
import com.onlinefoodorder.model.FoodItems;

public class FoodItemsDaoimpl implements FoodItemsDao
{
	public void insertFoodItems(FoodItems fooditem)
	{
		String insertQuery = "insert into food_items(restaurant_id, food_name, cuisine_name, description, price, food_image)values(?,?,?,?,?,?)";
		ConnectionUtil con = new ConnectionUtil();
		Connection c1 = con.getDbConnection();
		try {
			PreparedStatement p1 = c1.prepareStatement(insertQuery);
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
		}
	}
	public List<FoodItems> showFoodsbyRestaurant(int restaurantid)
	{
		List<FoodItems> foodnamelist = new ArrayList<FoodItems>();
		String query = "select * from food_items where restaurant_id = ?";
		Connection con = ConnectionUtil.getDbConnection();
		RestaurantdetailsDaoimpl restaurantdao= new RestaurantdetailsDaoimpl();
		try {
			PreparedStatement p1 = con.prepareStatement(query);
			p1.setInt(1, restaurantid);
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				String resName = restaurantdao.findRestaurantName(rs.getInt(1));
				FoodItems fooditem = new FoodItems(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getDouble(6), rs.getString(7),resName);
				foodnamelist.add(fooditem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return foodnamelist;
	}
//	public List<FoodItems> showFoodItems1()
//	{
//		List<FoodItems> foodItemList = new ArrayList< FoodItems>();
//		String showQuery = "select restaurant_id, item_id, food_name, cuisine_name, description, price, food_image, food_status from food_items";
//		Connection con = ConnectionUtil.getDbConnection();
//		FoodItems showFoodItems = new FoodItems();
//		RestaurantdetailsDaoimpl restaurantdao= new RestaurantdetailsDaoimpl();
//		try {
//				Statement stmt = con.createStatement();
//				ResultSet rs=stmt.executeQuery(showQuery);
//				while(rs.next())
//				{
//					String resName = restaurantdao.findRestaurantName(rs.getInt(1));
//					FoodItems fooditem = new FoodItems(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getDouble(6), rs.getString(7),resName);
//					foodItemList.add(fooditem);
//				}
//		}catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return foodItemList;
//	}
		
	public List<FoodItems> showFoodItems()
	{
		List<FoodItems> foodItemList = new ArrayList< FoodItems>();
		String showQuery = "select restaurant_id, item_id, food_name, cuisine_name, description, price, food_image, food_status from food_items";
		Connection con = ConnectionUtil.getDbConnection();
		FoodItems showFoodItems = new FoodItems();
		RestaurantdetailsDaoimpl restaurantdao= new RestaurantdetailsDaoimpl();
		try {
				Statement stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(showQuery);
				while(rs.next())
				{
					String resName = restaurantdao.findRestaurantName(rs.getInt(1));
					FoodItems fooditem = new FoodItems(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getDouble(6), rs.getString(7),resName);
					foodItemList.add(fooditem);
				}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return foodItemList;
	}
	public List<FoodItems> findfoodNames(int r_id)
	{
		List<FoodItems> foodnamelist = new ArrayList<FoodItems>();
		String query = "select food_name, price, foodimages from food_items where restaurant_id = "+r_id;
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement p1 = con.createStatement();
			ResultSet rs = p1.executeQuery(query);
			while(rs.next())
			{
				FoodItems fooditem = new FoodItems(r_id, rs.getString(3), rs.getString(4), rs.getString(5),rs.getDouble(6), rs.getString(7));
				foodnamelist.add(fooditem);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return foodnamelist;	
	}

	public String findFoodname(int foodid)
	{
		String findname = "select food_name from food_items where food_name = '"+foodid+"'";
		Connection con = ConnectionUtil.getDbConnection();
		String itemname = null;
		try {
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(findname);
			if(rs.next())
			{
				itemname = rs.getString(1);
			}
		} 
		catch (SQLException e) {
				e.printStackTrace();
		}
		return itemname;
	}
	
	public int findFoodPrice(int foodid)
	{
		String price ="select price from food_items where item_id= '"+foodid+"'";
		Connection con = ConnectionUtil.getDbConnection();
		Statement s1;
		int foodprice = 0;
		try {
			s1=con.createStatement();
			ResultSet rs = s1.executeQuery(price);
			if(rs.next())
			{
				foodprice = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodprice;			
	}
		
	public int finditemid(String foodname, int restaurantid)
	{
		String price ="select item_id from food_items where restaurant_id = ? and food_name = ?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement s1;
		
		try {
			s1=con.prepareStatement(price);
			s1.setInt(1, restaurantid);
			s1.setString(2, foodname);
			ResultSet rs = s1.executeQuery();
			while(rs.next())
			{
				System.out.println("insert");
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public void deletefooditem(int itemid)
	{
		String deleteQuery = "delete from food_items where itemid=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(deleteQuery);
			p1.setInt(1, itemid);
			int i = p1.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public List<FoodItems> filterbyPrice(double price)
	{
		List<FoodItems> foodnamelist = new ArrayList<FoodItems>();
		String query = "select * from food_items where price<=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(query);
			p1.setDouble(1, price);
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				FoodItems fooditem = new FoodItems(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7));
				foodnamelist.add(fooditem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodnamelist;
	}
	
	public List<FoodItems> filterbyfoodname(String foodname)
	{
		List<FoodItems> foodnamelist = new ArrayList<FoodItems>();
		String query = "select * from food_items where food_name=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(query);
			p1.setString(1, foodname);
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				FoodItems fooditem = new FoodItems(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getString(7));
				foodnamelist.add(fooditem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foodnamelist;
	}	
	@Override
	public int findFoodItemId(String foodName) {

		return 0;
	}
}
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
