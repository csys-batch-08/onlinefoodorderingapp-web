package com.foodorder.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;
@WebServlet("/addfoods")
public class AddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String email = request.getParameter("emailid");
		RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
		int restaurantid = restaurantdao.findRestaurantId(email);
	
		HttpSession session = request.getSession();
		session.setAttribute("restaurantid", restaurantid);
		RequestDispatcher rd = request.getRequestDispatcher("fooditems.jsp");
		rd.forward(request, response);
	}

}
