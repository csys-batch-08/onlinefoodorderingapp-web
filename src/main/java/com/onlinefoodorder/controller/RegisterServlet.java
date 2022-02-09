package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorder.model.User;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		
		try {
			String username = request.getParameter("username");
			long phoneno = (Long.parseLong(request.getParameter("phonenumber")));
			String address = request.getParameter("address");
			String emailid = request.getParameter("email");
			String password = request.getParameter("password");

			User user = new User(username, phoneno, address, emailid, password);
			UserDaoimpl userdao = new UserDaoimpl();
			userdao.insertUser(user);
			response.sendRedirect("index.jsp");
		} catch (NumberFormatException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}	
	}
}
