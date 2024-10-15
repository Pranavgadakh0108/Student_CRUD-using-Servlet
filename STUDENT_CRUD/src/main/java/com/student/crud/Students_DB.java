package com.student.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Students_DB {
	
	public static Connection createConnection()
	{
		Connection con = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_crud","root","pranav");
			System.out.println("Connection Created..");
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	
	public static int insertStudents(Student s)
	{
		int status = 0;
		
		try
		{
			Connection con = Students_DB.createConnection();
			PreparedStatement ps = con.prepareStatement("insert into student values (?,?,?,?,?)");
			ps.setInt(1, s.getRoll());
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setString(5, s.getCourse());
			
			status = ps.executeUpdate();
			con.close();
			
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
		
		return status;
	}
	
	public static List<Student> getAllStudents()
	{
		List<Student> list = new ArrayList<Student>();
		
		try
		{
			Connection con = Students_DB.createConnection();
			PreparedStatement ps = con.prepareStatement("select*from student");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Student s= new Student();
				s.setRoll(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setCourse(rs.getString(5));
				list.add(s);
			}
			con.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public static void deleteStudent(int roll)
	{
		try
		{
			Connection con = Students_DB.createConnection();
			PreparedStatement ps = con.prepareStatement("delete from student where roll=?");
			ps.setInt(1, roll);
			ps.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static Student getStudentRoll(int roll)
	{
		Student s = new Student();
		
		try 
		{
			Connection con = Students_DB.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from student where roll=?");
			ps.setInt(1, roll);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				s.setRoll(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setCourse(rs.getString(5));
			}
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return s;
	}
	
	public static int updateStudent(Student s)
	{
		int status =0;
		try
		{
			Connection con = Students_DB.createConnection();
			PreparedStatement ps = con.prepareStatement("update student set name=?,email=?,password=?,course=? where roll=?");
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setString(4, s.getCourse());
			ps.setInt(5, s.getRoll());
			
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
