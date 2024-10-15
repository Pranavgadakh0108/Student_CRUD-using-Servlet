package com.student.crud;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Add_Students")
public class Add_Students extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Student s = new Student();
		
		s.setName(req.getParameter("name"));
		s.setEmail(req.getParameter("email"));
		s.setPassword(req.getParameter("pass"));
		s.setCourse(req.getParameter("course"));
		
		int status = Students_DB.insertStudents(s);
		RequestDispatcher rd = req.getRequestDispatcher("Home.html");
		if(status>0)
		{
			out.print("<h2 style='color:green'>Recored Added Successfully!!!</h2>");
			rd.include(req, resp);
		}
		else
		{
			out.print("<h2 style='color:red'>Sorry!! Unable to Records...</h2>");
			rd.include(req, resp);
		}	
	}

}
