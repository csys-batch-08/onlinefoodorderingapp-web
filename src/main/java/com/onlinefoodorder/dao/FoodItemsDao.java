package com.onlinefoodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.FoodItems;

public interface FoodItemsDao
{
	public void insertFoodItems(FoodItems fooditem) throws SQLException
	, ClassNotFoundException;
	public List<FoodItems> showFoodsbyRestaurant(int restaurantid) throws SQLException, ClassNotFoundException;
	public List<FoodItems> showFoodItems() throws SQLException, ClassNotFoundException;
	public List<FoodItems> findfoodNames(int resid) throws SQLException, ClassNotFoundException;
	public String findFoodname(int foodid) throws SQLException, ClassNotFoundException;
	public int findFoodPrice(int foodid) throws SQLException, ClassNotFoundException;
	public int finditemid(String foodname, int restaurantid) throws SQLException, ClassNotFoundException;
	public void deletefooditem(int itemid) throws SQLException, ClassNotFoundException;
	public List<FoodItems> filterbyPrice(double price) throws SQLException, ClassNotFoundException;
	public List<FoodItems> filterbyfoodname(String foodname) throws SQLException, ClassNotFoundException;
}
