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

import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.model.FoodItems;

@WebServlet("/restaurantfoodlistSer")
public class RestaurantfoodlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		try {
			FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
			
			int restaurantid = Integer.parseInt(req.getParameter("rid"));
			
			List<FoodItems> foodItemList;
			foodItemList = fooditemdao.showFoodsbyRestaurant(restaurantid);

			req.setAttribute("foodItemList", foodItemList);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("restaurantFoodList.jsp");
			requestDispatcher.forward(req, resp);
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		
	}
}
