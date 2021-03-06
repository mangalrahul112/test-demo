package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dao.JDBCImpl;
import com.caps.dao.StudentsInfoDAO;
import com.caps.dto.Student;
import com.mysql.jdbc.Driver;




@WebServlet("/login")
public class LoginServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regno = req.getParameter("regno");
		String pass = req.getParameter("passwd");
		
		PrintWriter out = resp.getWriter();
		
		StudentsInfoDAO db = new JDBCImpl();
		Student res = db.searchByID(Integer.parseInt(regno),pass);
		
		
	if(res.getRole().equals("A"))
		{
		out.println("<a href='http://localhost:8080/MyCapsWebApp/detail'>View All Students</a>");
		out.print("<table border="+1+" cellspacing=+"+1+" cellpading="+1+"><tr><td><h2>RegNo</h2></td><td><h2>FName</h2></td><td><h2>LName</h2></td><td><h2>Role</h2></td></tr>"
				+"<tr><td><h3>"+res.getRegNo()+"</h3></td><td><h3>"+res.getFName()+"</h3></td><td><h3>"+res.getLName()
				+"</h3></td><td><h3>"+res.getRole()+"</tr></table>");
		}
	else if(res.getRole().equals("S"))
	{
		out.print("<table border="+1+" cellspacing=+"+1+" cellpading="+1+"><tr><td><h2>RegNo</h2></td><td><h2>FName</h2></td><td><h2>LName</h2></td><td><h2>Role</h2></td></tr>"
				+"<tr><td><h3>"+res.getRegNo()+"</h3></td><td><h3>"+res.getFName()+"</h3></td><td><h3>"+res.getLName()
				+"</h3></td><td><h3>"+res.getRole()+"</tr></table>");
	}
	
	}
}
