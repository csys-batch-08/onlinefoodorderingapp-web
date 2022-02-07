package com.onlinefoodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.FoodItems;

public interface FoodItemsDao
{
	public void insertFoodItems(FoodItems fooditem) throws SQLException
	, ClassNotFoundException;
	public List<FoodItems> showFoodsbyRestaurant(int restaurantid) throws SQLException;
	public List<FoodItems> showFoodItems() throws SQLException;
	public List<FoodItems> findfoodNames(int resid) throws SQLException;
	public String findFoodname(int foodid) throws SQLException;
	public int findFoodPrice(int foodid) throws SQLException;
	public int finditemid(int restaurantid, String foodname) throws SQLException;
	public List<FoodItems> filterbyfoodname(String foodname) throws SQLException;
}
