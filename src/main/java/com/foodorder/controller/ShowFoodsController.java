package com.foodorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.model.FoodItems;

@WebServlet("/showfoodsservlet")
public class ShowFoodsController extends HttpServlet{

	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException 
{
		try {
				FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
				List<FoodItems> foodItemList = fooditemdao.showFoodItems(); 
				req.setAttribute("fooditemslistobj", foodItemList);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("showfoods.jsp");
				requestDispatcher.forward(req, resp);		
		} catch (IOException e) {
				e.printStackTrace();
			}catch(ServletException e) {
				e.printStackTrace();
			}
	}
}