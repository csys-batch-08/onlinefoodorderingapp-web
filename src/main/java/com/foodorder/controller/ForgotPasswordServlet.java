package com.foodorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.UserDaoimpl;

@WebServlet("/forgotpassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDaoimpl userdao = new UserDaoimpl();
		boolean flag=userdao.forgotPassword(email, password);
		if (flag==true)
		response.sendRedirect("login.jsp");
		else
			System.out.println("failed");
	}
}