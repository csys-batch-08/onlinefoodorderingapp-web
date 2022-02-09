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

import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/activeusers")
public class ActiveuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			String email = request.getParameter("email");
			UserDaoimpl userdao = new UserDaoimpl();
			userdao.userProfileActive(email);
			String userName = userdao.findUserName(email);
			request.setAttribute("username", userName);
			
			HttpSession session = request.getSession();
			session.setAttribute("ActiveUser", "Successfully Active");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("admin.jsp");
			requestdispatcher.forward(request, response);
		 } catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		 }catch (ServletException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
