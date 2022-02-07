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

public class FoodItemsDaoimpl implements FoodItemsDao {
	
	// Admin register the food items
	public void insertFoodItems(FoodItems fooditem) throws SQLException {
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
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
	}

	// user view the food items by restaurant
	public List<FoodItems> showFoodsbyRestaurant(int restaurantid) throws SQLException {
		List<FoodItems> foodnamelist = new ArrayList<>();
		String query = "select restaurant_id, item_id, food_name, cuisine_name, description, price, food_image from food_items where restaurant_id = ?";
		Connection con = null;
		RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, restaurantid);
			rs = p1.executeQuery();
			while (rs.next()) {
				String resName = restaurantdao.findRestaurantName(rs.getInt(1));
				FoodItems fooditem = new FoodItems(rs.getInt("Restaurant_id"), rs.getInt("item_id"),rs.getString("Food_name"), rs.getString("Cuisine_name"), rs.getString("Description"),rs.getDouble("Price"), rs.getString("Food_image"), resName);
				foodnamelist.add(fooditem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return foodnamelist;
	}

	// User View all food items
	public List<FoodItems> showFoodItems() throws SQLException {
		List<FoodItems> foodItemList = new ArrayList<>();
		String showQuery = "select restaurant_id, item_id, food_name, cuisine_name, description, price, food_image from food_items";
		Connection con = null;
		RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(showQuery);
			while (rs.next()) {
				String resName = restaurantdao.findRestaurantName(rs.getInt("Restaurant_id"));
				FoodItems fooditem = new FoodItems(rs.getInt("restaurant_id"), rs.getInt("item_id"),rs.getString("Food_Name"), rs.getString("Cuisine_Name"), rs.getString("Description"),rs.getDouble("Price"), rs.getString("Food_Image"), resName);
				foodItemList.add(fooditem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return foodItemList;
	}

	// Find food name through RestaurantId
	public List<FoodItems> findfoodNames(int resid) throws SQLException {
		List<FoodItems> foodnamelist = new ArrayList<>();
		String query = "select food_name, price, foodimages from food_items where restaurant_id = ?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, resid);
			ResultSet rs = p1.executeQuery();
			while (rs.next()) {
				FoodItems fooditem = new FoodItems(resid, rs.getString("food_name"), rs.getString("cuisine_name"),rs.getString("description"), rs.getDouble("price"), rs.getString("food_image"));
				foodnamelist.add(fooditem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return foodnamelist;
	}

	// Find Food Name through FoodId
	public String findFoodname(int foodid) throws SQLException {
		String findname = "select food_name from food_items where food_name = ?";
		Connection con = null;
		String itemname = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(findname);
			p1.setInt(1, foodid);
			rs = p1.executeQuery();
			if (rs.next()) {
				itemname = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return itemname;
	}

	// Find Food Price through foodId
	public int findFoodPrice(int foodid) throws SQLException {
		String price = "select price from food_items where item_id= ?";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		int foodprice = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(price);
			p1.setInt(1, foodid);
			rs = p1.executeQuery();
			if (rs.next()) {
				foodprice = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return foodprice;
	}

	// Find ItemId 
	public int finditemid(int restaurantid, String foodname) throws SQLException {
		String price = "select item_id from food_items where restaurant_id = ? and food_name = ?";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;

		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(price);
			p1.setInt(1, restaurantid);
			p1.setString(2, foodname);
			rs = p1.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return -1;
	}

	// Filter Foods by food name
	public List<FoodItems> filterbyfoodname(String foodname) throws SQLException {
		List<FoodItems> foodnamelist = new ArrayList<>();
		String fname = "%" +foodname+ "%";
		String query = "select restaurant_id, item_id, food_name, cuisine_name, description, price, food_image, food_status from food_items where food_name like ";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setString(1, foodname);
			rs = p1.executeQuery();
			while (rs.next()) {
				FoodItems fooditem = new FoodItems(rs.getInt("restaurant_id"), rs.getString("food_name"),rs.getString("cuisine_name"), rs.getString("description"), rs.getDouble("price"),
						rs.getString("food_image"));
				foodnamelist.add(fooditem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return foodnamelist;
	}
}
