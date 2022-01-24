package com.foodorder.dao;

import java.util.List;

import com.onlinefoodorder.model.Orderfoods;

public interface OrderFoodsDao 
{
	public void insertOrderFoods(Orderfoods order);
	public List<Orderfoods> viewOrderFoods();
	public void updateOrderdetails(int quantity, int item_id);
	public void deleteOrder(int item_id);
}
