package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/forgotpassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			UserDaoimpl userdao = new UserDaoimpl();
			boolean flag;
			flag = userdao.forgotPassword(email, password);
			if(flag) {
				response.sendRedirect("index.jsp");
			}
		}catch (IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
		
	}
}
