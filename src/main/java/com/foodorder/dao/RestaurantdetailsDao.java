package com.foodorder.dao;

import com.onlinefoodorder.model.RestaurantDetails;

public interface RestaurantdetailsDao 
{
	public void insertRestaurantDetails(RestaurantDetails restaurant);
	public void restaurantUpdate(String email, String password);
	public void deleteRestaurant(String email);
	public int findRestaurantId(String email);
	public int findRestaurantId2(String restaurantName);
	
}
