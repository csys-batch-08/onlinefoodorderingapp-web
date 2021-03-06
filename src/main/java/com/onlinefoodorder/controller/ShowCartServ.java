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
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.dao.impl.CartDaoimpl;
import com.onlinefoodorder.model.FoodItems;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/ShowCartServ")
public class ShowCartServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){	
	try {
			HttpSession session = request.getSession();
			CartDaoimpl cartDaoimpl = new CartDaoimpl();
			int userid = (int)session.getAttribute("Userid1");
			List<FoodItems> foodlist = cartDaoimpl.fetchCart(userid);
			request.setAttribute("foodlist", foodlist);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("showCart.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}	
	}
}
