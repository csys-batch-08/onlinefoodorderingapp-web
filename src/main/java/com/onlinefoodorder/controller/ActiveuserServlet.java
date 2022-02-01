package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.UserDaoimpl;

@WebServlet("/activeusers")
public class ActiveuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			String email = request.getParameter("email");
			UserDaoimpl userdao = new UserDaoimpl();
			userdao.userProfileActive(email);
			String userName = userdao.findUserName(email);
			request.setAttribute("username", userName);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("userActiveMsg.jsp");
			requestdispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
