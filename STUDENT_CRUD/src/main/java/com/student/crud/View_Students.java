package com.student.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/View_Students")
public class View_Students extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		List<Student> list = Students_DB.getAllStudents();
		
		out.print("<body style='font-family: Arial, Helvetica, sans-serif;'>");
		out.print("<button style='background-color: hotpink; color:black; border-radius:5px; padding:10px;'><a href='Home.html'>Home</a></button>");
		out.print("<h2 style='color:blue'>STUDENTS RECORDS</h2>");
		out.print("<table border='1' width='100%'");  
        out.print("<tr><th style='background-color: lightskyblue;'>Roll</th><th style='background-color: lightskyblue;'>Name</th><th style='background-color: lightskyblue;'>Email</th><th style='background-color: lightskyblue;'>Password</th><th style='background-color: lightskyblue;'>Course</th><th style='background-color: lightskyblue;'>Update</th><th style='background-color: lightskyblue;'>Delete</th></tr>");  
        for(Student e:list){  
         out.print("<tr style=' text-align: center;'><td>"+e.getRoll()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td>"
         		+ "<td>"+e.getPassword()+"</td><td>"+e.getCourse()+"</td>"
         				+ "<td><button style='background-color:lawngreen; color:black; border-radius:5px; padding:3px;'><a href='Update_Student?roll="+e.getRoll()+"'>Update</a></button></td>"
         						+ "<td><button style='background-color:orange; color:black; border-radius:5px; padding:3px;'><a href='Delete_Student?roll="+e.getRoll()+"'>Delete</a></button></td></tr>");  
        }  
        out.print("</table>"); 
        out.print("</body>");
		out.close();
	}

	
}
