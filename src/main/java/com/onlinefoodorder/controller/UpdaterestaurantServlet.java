package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.dao.impl.RestaurantdetailsDaoimpl;
import com.onlinefoodorder.model.RestaurantDetails;
import com.onlinefoodorderingapp.logger.Logger;


@WebServlet("/updaterestaurantdetail")
public class UpdaterestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		
		try {
			String restaurantname = request.getParameter("restaurantname");
			long landlineno = Long.parseLong(request.getParameter("landlineno"));
			String ownername = request.getParameter("ownername");
			String time = request.getParameter("time");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			RestaurantDetails restaurant = new RestaurantDetails(restaurantname, null, null, 0, landlineno, ownername, time, email, password, null);
			RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
			restaurantdao.restaurantUpdate(restaurant);
			HttpSession session = request.getSession();
			session.setAttribute("updaterestaurant", "Restaurant Details are updated");
			response.sendRedirect("admin.jsp");
		} catch (NumberFormatException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}	
	}
}
