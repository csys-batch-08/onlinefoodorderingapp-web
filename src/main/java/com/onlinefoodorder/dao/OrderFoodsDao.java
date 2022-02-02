package com.onlinefoodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.Orderfoods;

public interface OrderFoodsDao 
{
	public void insertOrderFoods(Orderfoods order) throws SQLException;
	public List<Orderfoods> viewOrderFoods() throws SQLException;
	public List<Orderfoods> userViewOrder(int userid) throws SQLException;
	public int updateOrderdetails(int orderId) throws SQLException;
	public String findOrderstatus(int orderId) throws SQLException;
	public int findfoodPrice(int orderid) throws SQLException;
}
