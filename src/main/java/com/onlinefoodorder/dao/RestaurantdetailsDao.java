package com.onlinefoodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.RestaurantDetails;

public interface RestaurantdetailsDao 
{
	public boolean insertRestaurantDetails(RestaurantDetails restaurant) throws SQLException;
	public boolean restaurantUpdate(RestaurantDetails restaurant) throws SQLException;
	public int inactiveRestaurant(String emailid) throws SQLException;
	public int activeRestaurant(String emailid) throws SQLException;
	public int findRestaurantId(String email) throws SQLException;
	public int findRestaurantId2(String restaurantName) throws SQLException;
	public String findRestaurantName(int restaurantId) throws SQLException;
	public List<RestaurantDetails> showRestaurant() throws SQLException;
	public List<RestaurantDetails> filterbyCity(String city) throws SQLException;
}
