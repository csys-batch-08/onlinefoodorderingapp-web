package com.onlinefoodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.Orderfoods;

public interface OrderFoodsDao 
{
	public void insertOrderFoods(Orderfoods order) throws SQLException, ClassNotFoundException;
	public List<Orderfoods> viewOrderFoods() throws SQLException, ClassNotFoundException;
	public List<Orderfoods> userViewOrder(int userid) throws SQLException, ClassNotFoundException;
	public int updateOrderdetails(int orderId) throws SQLException, ClassNotFoundException;
	public String findOrderstatus(int orderId) throws SQLException, ClassNotFoundException;
	public void deleteOrder(int itemId) throws SQLException, ClassNotFoundException;
	public int findfoodPrice(int orderid) throws SQLException, ClassNotFoundException;
}
