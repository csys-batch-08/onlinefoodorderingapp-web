package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.onlinefoodorder.dao.impl.FoodItemsDaoimpl;
import com.onlinefoodorder.model.FoodItems;
import com.onlinefoodorderingapp.logger.Logger;
@WebServlet("/foodorderserv")
public class FooditemsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{		
		try {
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
			response.sendRedirect("admin.jsp");
			} catch (NumberFormatException | IOException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
	}
}

 