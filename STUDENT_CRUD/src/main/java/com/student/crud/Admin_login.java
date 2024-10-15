package com.student.crud;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Admin_login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		
		if(uname.equalsIgnoreCase("admin"))
		{
			if(pass.equalsIgnoreCase("admin"))
			{
				resp.sendRedirect("Home.html");
			}
			else
			{
				out.print("<h2 style='color:red'> Incorrect Password!!!</h2>");
				rd.include(req, resp);	
			}
		}
		else
		{
			out.print("<h2 style='color:red'> Incorrect Username!!!</h2>");
			rd.include(req, resp);	
		}
	}

}
