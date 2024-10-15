package com.student.crud;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Updated_Students")
public class Updated_Students extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int roll =Integer.parseInt(req.getParameter("roll"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String course = req.getParameter("course");
		
		Student s = new Student();
		s.setRoll(roll);
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setCourse(course);
		
		int status = Students_DB.updateStudent(s);
		if(status>0)
		{
			resp.sendRedirect("View_Students");
		}
		else
		{
			out.print("<h2 style='color:red'>Sorry!!, Unable to Update</h2>");
			RequestDispatcher rd = req.getRequestDispatcher("Update_Student");
			rd.include(req, resp);
		}
	}

}
