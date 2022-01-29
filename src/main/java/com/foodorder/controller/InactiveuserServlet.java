package com.foodorder.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.UserDaoimpl;
import com.onlinefoodorder.model.User;

@WebServlet("/inactiveusers")
public class InactiveuserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("email");
			UserDaoimpl userdao = new UserDaoimpl();
			userdao.userProfileDelete(email);
			HttpSession session = request.getSession();
			session.setAttribute("userInactiver", "User Inactive");
			response.sendRedirect("admin.jsp");	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
