package com.foodorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.UserDaoimpl;
import com.onlinefoodorder.model.User;


@WebServlet("/updateuser1")
public class UpdateuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		Long phonenumber = Long.parseLong(request.getParameter("phonenumber"));
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(username, phonenumber, address, email, password);
		System.out.println(user);
		
		UserDaoimpl userdao = new UserDaoimpl();
		userdao.userProfileUpdate(user);
		response.sendRedirect("userprofile.jsp");	
		}
}
