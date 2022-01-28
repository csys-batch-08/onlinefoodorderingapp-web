package com.foodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.RestaurantDetails;

public interface RestaurantdetailsDao 
{
	public void insertRestaurantDetails(RestaurantDetails restaurant) throws SQLException;
	public void restaurantUpdate(RestaurantDetails restaurant) throws SQLException;
	public void inactiveRestaurant(String emailid) throws SQLException;
	public void activeRestaurant(String emailid) throws SQLException;
	public int findRestaurantId(String email) throws SQLException;
	public int findRestaurantId2(String restaurantName) throws SQLException;
	public String findRestaurantName(int restaurantId) throws SQLException;
	public int findmaxresid() throws SQLException;	
	public List<RestaurantDetails> showRestaurant() throws SQLException;
	public List<RestaurantDetails> filterbyCity(String city) throws SQLException;
}
