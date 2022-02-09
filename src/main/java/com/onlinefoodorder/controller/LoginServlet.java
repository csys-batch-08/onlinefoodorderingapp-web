package com.onlinefoodorder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorder.model.User;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/userlogin")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
			try {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
	
				UserDaoimpl userdao = new UserDaoimpl();
				User user = userdao.validateUser(email, password);
				User admin = userdao.validateAdmin(email, password);
				
				PrintWriter pw = response.getWriter();
				HttpSession session = request.getSession();
				if(user!=null)
				{
					pw.write("welcome " +user.getUserName());
					
					session.setAttribute("user", user);
					String username=user.getUserName();
				
					session.setAttribute("username", username);
					int userid;
					userid = userdao.findUserId(email);
					session.setAttribute("Userid1", userid);
					
					session.setAttribute("emailid", email);
					response.sendRedirect("showfoodsservlet");
				}
				else if(admin!=null)
				{
					session.setAttribute("admin", admin);
					response.sendRedirect("admin.jsp");
				}
				else
				{
					session.setAttribute("validateUser", "Invalid Email address & Password");
					response.sendRedirect("index.jsp");
				}
			} catch (SQLException | IOException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			} 
	}
}
