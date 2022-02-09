package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.dao.impl.OrderFoodsDaoimpl;
import com.onlinefoodorder.model.Orderfoods;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/ViewOrderServ")
public class ViewOrderServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	{	
		try {
			OrderFoodsDaoimpl orderfood = new OrderFoodsDaoimpl(); 
			List<Orderfoods> orderlist;
			orderlist = orderfood.viewOrderFoods();
			request.setAttribute("orderList", orderlist);
			
			RequestDispatcher rd = request.getRequestDispatcher("viewOrders.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} 
	}
}
