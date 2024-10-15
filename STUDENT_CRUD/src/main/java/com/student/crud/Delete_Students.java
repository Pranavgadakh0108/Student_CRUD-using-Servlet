package com.student.crud;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Delete_Student")
public class Delete_Students extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	{
		try
		{
			Students_DB.deleteStudent(Integer.parseInt(req.getParameter("roll")));
			resp.sendRedirect("View_Students");
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
