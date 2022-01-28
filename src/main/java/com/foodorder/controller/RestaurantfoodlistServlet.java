package com.foodorder.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;
import com.onlinefoodorder.model.FoodItems;

@WebServlet("/restaurantfoodlistSer")
public class RestaurantfoodlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
		
		int restaurantid = Integer.parseInt(req.getParameter("rid"));
		
		List<FoodItems> foodItemList = fooditemdao.showFoodsbyRestaurant(restaurantid);
		
		req.setAttribute("foodItemList", foodItemList);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("restaurantfoodlist.jsp");
		requestDispatcher.forward(req, resp);
	}
}
