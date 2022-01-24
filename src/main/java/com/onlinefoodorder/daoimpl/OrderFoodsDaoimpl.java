package com.onlinefoodorder.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.foodorder.dao.OrderFoodsDao;
import com.foodorder.util.ConnectionUtil;
import com.onlinefoodorder.model.Orderfoods;

public class OrderFoodsDaoimpl implements OrderFoodsDao
{
	public void insertOrderFoods(Orderfoods order)
	{
		String insert = "insert into order_foods(user_id, item_id, quantity, total_price) values(?,?,?,?)";
		String query = "commit";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(insert);
			p1.setInt(1, order.getUser_id());
			p1.setInt(2, order.getItem_id());
			p1.setInt(3, order.getQuantity());
			p1.setDouble(4, order.getTotal_price());
			p1.executeUpdate();
			p1.executeUpdate(query);
			System.out.println("Successfully inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Orderfoods> viewOrderFoods()
	{
		List<Orderfoods> orderlist = new ArrayList<Orderfoods>();
		String showQuery = "select * from order_foods";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(showQuery);
			while(rs.next())
			{
				Orderfoods order = new Orderfoods(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4), rs.getDouble(5), rs.getDate(6).toLocalDate(), rs.getString(7));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderlist;
	}
	
	public List<Orderfoods> userViewOrder(int userid)
	{
		List<Orderfoods> orderlist = new ArrayList<Orderfoods>();
		String showQuery = "select * from order_foods where user_id='"+userid+"'";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(showQuery);
			while(rs.next())
			{
				Orderfoods order = new Orderfoods(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDate(6).toLocalDate(),rs.getString(7));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderlist;
	}
	public int updateOrderdetails(int order_id)
	{
		String updateQuery="update order_foods set order_status = 'Cancel' where order_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1=con.prepareStatement(updateQuery);
			p1.setInt(1, order_id);
			int i=p1.executeUpdate();
			p1.executeUpdate("commit");
			System.out.println(i+" row updated");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Try again");
		}
		return 0;
	}	
	
	public String findOrderstatus(int order_id)
	{
		String findQuery="select order_status from order_foods where order_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1=con.prepareStatement(findQuery);
			p1.setInt(1, order_id);
			int i=p1.executeUpdate();
			p1.executeUpdate("commit");
			System.out.println(i+" row updated");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Try again");
		}
		return null;
	}
	
	public void deleteOrder(int item_id) 
	{
		String delete="delete order_foods from where item_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement p1 = null;
		try {
			p1=con.prepareStatement(delete);
			p1.setInt(1, item_id);
			int i=p1.executeUpdate();
			System.out.println(i+ " row deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int findfoodPrice(int orderid)
	{
		String price ="select price from order_foods where order_id= '"+orderid+"'";
		Connection con = ConnectionUtil.getDbConnection();
		Statement s1;
		int foodprice = 0;
		try {
			s1=con.createStatement();
			ResultSet rs = s1.executeQuery(price);
			if(rs.next())
			{
				foodprice = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodprice;			
	}
	
	@Override
	public void updateOrderdetails(int quantity, int item_id) {
		// TODO Auto-generated method stub
		
	}
}



















