package com.onlinefoodorder.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/OrderFoodsServ")
public class OrderFoodsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response){
		try {	
			int rid = Integer.parseInt(request.getParameter("resid"));
			String foodname = request.getParameter("fname");
		
			request.setAttribute("restaurantId", rid);
			request.setAttribute("foodname", foodname);
		
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("orderFoods.jsp");
			requestdispatcher.forward(request, response);
		} catch (ServletException | IOException | NumberFormatException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
