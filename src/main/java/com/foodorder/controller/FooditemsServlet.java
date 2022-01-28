package com.foodorder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
import com.onlinefoodorder.model.RestaurantDetails;
@WebServlet("/foodorderserv")
public class FooditemsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try {
			RestaurantdetailsDaoimpl restaurant = new RestaurantdetailsDaoimpl();
			HttpSession session = request.getSession();
			
			String foodname = request.getParameter("foodname");
			String cuisinename = request.getParameter("cuisine");
			String description = request.getParameter("description");
			double price = Double.parseDouble(request.getParameter("price"));
			String foodimages = request.getParameter("foodimage");
			
			int resid = (int)session.getAttribute("restaurantid");
			
			session.setAttribute("food", foodname);
			
			FoodItems food = new FoodItems(resid, foodname, cuisinename, description, price, foodimages);
			FoodItemsDaoimpl foodItemsDaoimpl = new FoodItemsDaoimpl();
			foodItemsDaoimpl.insertFoodItems(food);
			PrintWriter pw = response.getWriter();
			pw.write("food items are successfully inserted");
			response.sendRedirect("admin.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

 