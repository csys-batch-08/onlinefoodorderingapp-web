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

import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorder.model.User;

@WebServlet("/UserProfileServ")
public class UserProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			HttpSession session = request.getSession();
			int customerid = (int)session.getAttribute("Userid1");
			UserDaoimpl userdao = new UserDaoimpl();
			List<User> userList = userdao.currentuserprofile(customerid);
			request.setAttribute("userlist", userList);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("userProfile.jsp");
			requestdispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
