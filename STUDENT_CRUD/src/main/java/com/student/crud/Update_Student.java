package com.student.crud;

import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Update_Student")
public class Update_Student extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	{
		try
		{
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			Student s =Students_DB.getStudentRoll(Integer.parseInt(req.getParameter("roll")));
		
			out.print("<form action='Updated_Students' method='post'"
					+ "style='border: 2px solid blueviolet;border-radius: 10px;margin-top: 20px; padding: 20px; background-color: lightpink; font-family: Arial, Helvetica, sans-serif;'>");
			out.print("<h2 style='color:blue'>UPDATE STUDENT</h2>");
			out.print("<table style = 'font-weight: bolder;'>");
			out.print("<tr><td></td><td><input type='hidden' name='roll' value='"+s.getRoll()+"'/></td></tr>");
			out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+s.getName()+"'/></td></tr>");
			out.print("<tr><td>Password:</td><td><input type='email' name='email' value='"+s.getEmail()+"'/></td></tr>");
			out.print("<tr><td>Email:</td><td><input type='password' name='password' value='"+s.getPassword()+"'/></td></tr>");
			out.print("<tr><td>Course:</td><td>");
			out.print("<select name='course' value='"+s.getCourse()+"' style='width:150px'>");
			out.print("<option>Full Stack Java</option>");
			out.print("<option>Full Stack Python</option>");
			out.print("<option>Software Testing</option>");
			out.print("<option>Web Development</option>");
			out.print("</select>");
			out.print("</td></tr>");
			out.print("<tr><td colspan='2'><input type='submit' value='Update & Save' style='background-color:yellow; padding:5px; border-radius:10px;'/></td></tr>");
			out.print("</table>");
			out.print("</form>");
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
