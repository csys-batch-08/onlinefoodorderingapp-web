package com.foodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.FoodItems;

public interface CartDao {
	public void insertCart(int itemId,int customerid) throws SQLException;
	public List<FoodItems> fetchCart(int userid) throws SQLException;
	public int removeCart(int itemId, int userId) throws SQLException;
	
	
}
