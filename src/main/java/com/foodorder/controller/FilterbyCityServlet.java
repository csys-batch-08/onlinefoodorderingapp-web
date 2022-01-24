package com.foodorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;
@WebServlet("/filterbycity")
public class FilterbyCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city = request.getParameter("city");
		RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
		restaurantdao.filterbyCity(city);
		HttpSession session = request.getSession();
		session.setAttribute(city, "city");
		System.out.println("sercity: "+city);
		response.sendRedirect("filterbyCity.jsp");
	}
}
