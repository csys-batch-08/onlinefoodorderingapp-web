package com.onlinefoodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.RestaurantDetails;

public interface RestaurantdetailsDao 
{
	public void insertRestaurantDetails(RestaurantDetails restaurant) throws SQLException, ClassNotFoundException;
	public void restaurantUpdate(RestaurantDetails restaurant) throws SQLException, ClassNotFoundException;
	public int inactiveRestaurant(String emailid) throws SQLException, ClassNotFoundException;
	public void activeRestaurant(String emailid) throws SQLException, ClassNotFoundException;
	public int findRestaurantId(String email) throws SQLException, ClassNotFoundException;
	public int findRestaurantId2(String restaurantName) throws SQLException, ClassNotFoundException;
	public String findRestaurantName(int restaurantId) throws SQLException, ClassNotFoundException;
	public int findmaxresid() throws SQLException, ClassNotFoundException;	
	public List<RestaurantDetails> showRestaurant() throws SQLException, ClassNotFoundException;
	public List<RestaurantDetails> filterbyCity(String city) throws SQLException, ClassNotFoundException;
}
