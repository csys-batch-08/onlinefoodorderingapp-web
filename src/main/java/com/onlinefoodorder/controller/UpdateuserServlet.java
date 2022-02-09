package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorder.model.User;
import com.onlinefoodorderingapp.logger.Logger;


@WebServlet("/updateuser1")
public class UpdateuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		
		try {
			HttpSession session = request.getSession();
			String username = request.getParameter("username");
			Long phonenumber = Long.parseLong(request.getParameter("phonenumber"));
			String address = request.getParameter("address");
			String password = request.getParameter("password");
			String emailid = (String) session.getAttribute("emailid");
			
			User user = new User(username, phonenumber, address, emailid, password);
			
			UserDaoimpl userdao = new UserDaoimpl();
			userdao.userProfileUpdate(user);
			response.sendRedirect("UserProfileServ");
		} catch (NumberFormatException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}		
	}
}
