package com.foodorder.dao;

import java.util.List;

import com.onlinefoodorder.model.FoodItems;

public interface FoodItemsDao
{
	public void insertFoodItems(FoodItems fooditem);
	public List<FoodItems> showFoodItems();
	public List<FoodItems> findfoodNames(int r_id);
	public int findFoodItemId(String food_name);
	public int findFoodPrice(int foodid);
}
