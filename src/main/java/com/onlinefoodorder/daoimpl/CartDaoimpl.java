package com.onlinefoodorder.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodorder.util.ConnectionUtil;
import com.onlinefoodorder.model.FoodItems;

public class CartDaoimpl
{
	public void insertCart(int itemId,int customerid)
	{	 
		String insertQuery = "insert into cart(user_id,item_id)values(?,?)";
		ConnectionUtil con = new ConnectionUtil();
		Connection c1 = con.getDbConnection();
		PreparedStatement p1;
		int itemid=0;
		try {
			p1 = c1.prepareStatement(insertQuery);
			p1.setInt(1,customerid );
			p1.setInt(2, itemId);
			 
			p1.executeUpdate();
			p1.executeUpdate("commit");
			System.out.println("Food items are inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<FoodItems> fetchCart(int userid) 
	{
		List<FoodItems> foodItems = new ArrayList<FoodItems>();
		String Query = "select * from food_items where item_id in (select item_id from cart where user_id = ?) ";
		ConnectionUtil con = new ConnectionUtil();
		Connection c1 = con.getDbConnection();
		try {
			PreparedStatement p1 = c1.prepareStatement(Query);
			p1.setInt(1, userid);
			ResultSet rs = p1.executeQuery();
			while(rs.next()) {
				foodItems.add(new FoodItems(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodItems;
	}
	public int removeCart(int itemId, int userId) 
	{
		String deletecart="delete from cart where item_id = ? and user_id = ?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement p1 = null;
		try {
			p1=con.prepareStatement(deletecart);
			p1.setInt(1, itemId);
			p1.setInt(2, userId);
			int i=p1.executeUpdate();
			System.out.println(i+ " row deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}	
}
