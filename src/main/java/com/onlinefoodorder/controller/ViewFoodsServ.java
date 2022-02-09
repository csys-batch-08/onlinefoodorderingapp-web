package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.dao.impl.FoodItemsDaoimpl;
import com.onlinefoodorder.model.FoodItems;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/ViewFoodsServ")
public class ViewFoodsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response){	
		try {
			FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
			List<FoodItems> foodItemList;
			foodItemList = fooditemdao.showFoodItems();
			request.setAttribute("foodItemlist", foodItemList);
			RequestDispatcher rd = request.getRequestDispatcher("viewFoods.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
