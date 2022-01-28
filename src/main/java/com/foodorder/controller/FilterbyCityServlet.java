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

import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;
import com.onlinefoodorder.model.RestaurantDetails;
@WebServlet("/filterbycityserv")
public class FilterbyCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
		String city = request.getParameter("city");
		
		List<RestaurantDetails> restaurantlist = restaurantdao.filterbyCity(city);
		
		request.setAttribute("restaurantList", restaurantlist);
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("filterbyCity.jsp");
		requestdispatcher.forward(request, response);
	}
}