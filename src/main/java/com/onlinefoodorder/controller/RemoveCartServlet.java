package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.CartDaoimpl;

@WebServlet("/removeCartserv")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			CartDaoimpl cartdao = new CartDaoimpl();
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			int userId = (int)session.getAttribute("Userid1");
			session.setAttribute("cartid", itemId);
			cartdao.removeCart(itemId, userId);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ShowCartServ");
			requestDispatcher.forward(request, response);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
