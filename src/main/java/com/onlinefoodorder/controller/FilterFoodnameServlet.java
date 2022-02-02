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

import com.onlinefoodorder.dao.impl.FoodItemsDaoimpl;
import com.onlinefoodorder.model.FoodItems;
 @WebServlet("/filterfoods")
public class FilterFoodnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try {
			FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
			
			String foodname = request.getParameter("search");
			
			List<FoodItems> foodItemList;
			foodItemList = fooditemdao.filterbyfoodname(foodname);
			request.setAttribute("filterfoods", foodItemList);
			
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("filterFoodNames.jsp");
			requestdispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
