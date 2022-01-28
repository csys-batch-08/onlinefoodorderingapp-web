package com.foodorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.daoimpl.OrderFoodsDaoimpl;
import com.onlinefoodorder.model.Orderfoods;

@WebServlet("/ViewOrderServ")
public class ViewOrderServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		OrderFoodsDaoimpl orderfood = new OrderFoodsDaoimpl(); 
		List<Orderfoods> orderlist = orderfood.viewOrderFoods();
		
		request.setAttribute("orderList", orderlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("vieworders.jsp");
		rd.forward(request, response);
	}
}
