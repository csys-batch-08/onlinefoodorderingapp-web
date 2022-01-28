package com.foodorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;
import com.onlinefoodorder.model.RestaurantDetails;

@WebServlet("/ViewrestaurantServ")
public class ViewrestaurantServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
		List<RestaurantDetails> restaurantlist= restaurantdao.showRestaurant();
		
		request.setAttribute("restaurantList", restaurantlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewrestaurant.jsp");
		rd.forward(request, response);
	}

}
