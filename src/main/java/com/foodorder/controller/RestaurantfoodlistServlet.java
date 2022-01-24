package com.foodorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/restaurantfoodlistSer")
public class RestaurantfoodlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int restaurantid = Integer.parseInt(request.getParameter("rid"));
		HttpSession session = request.getSession();
		session.setAttribute("resid", restaurantid);
		response.sendRedirect("restaurantfoodlist.jsp");
	}

}
