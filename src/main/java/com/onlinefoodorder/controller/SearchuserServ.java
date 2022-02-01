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
import com.onlinefoodorder.daoimpl.UserDaoimpl;
import com.onlinefoodorder.model.User;

@WebServlet("/searchUser")
public class SearchuserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try {
			String emailid = request.getParameter("email");
			
			UserDaoimpl userdao = new UserDaoimpl();
			List<User> userList = userdao.viewSingleUser(emailid);
			
			request.setAttribute("userlist", userList);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("adminSearchUser.jsp");
			requestdispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
