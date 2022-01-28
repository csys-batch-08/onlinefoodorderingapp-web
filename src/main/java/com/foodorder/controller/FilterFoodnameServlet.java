package com.foodorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.model.FoodItems;
 @WebServlet("/filterfoods")
public class FilterFoodnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
		HttpSession session = request.getSession();
		
		String foodname = request.getParameter("search");
		
		List<FoodItems> foodItemList = fooditemdao.filterbyfoodname(foodname);
		
		request.setAttribute("filterfoods", foodItemList);
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("filterbyfoodnames.jsp");
		requestdispatcher.forward(request, response);
	}
}
