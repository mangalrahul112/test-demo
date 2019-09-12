package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dao.JDBCImpl;
import com.caps.dao.StudentsInfoDAO;
import com.caps.dto.Student;





@WebServlet("/detail")
public class AllStudentsServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		
		StudentsInfoDAO db = new JDBCImpl();
		ArrayList<Student> res = db.viewAllStudents();
		
		out.println("<table border="+1+" cellspacing=+"+1+" cellpading="+1+
				"><tr><td><h2>RegNo</h2></td><td><h2>FName</h2></td><td><h2>LName</h2></td><td><h2>Role</h2></td></tr>");
		for(Student s:res)
		{
		
			out.println("<tr><td><h3>"+s.getRegNo()+"</h3></td><td><h3>"+s.getFName()+"</h3></td><td><h3>"+s.getLName()
				+"</h3></td>"+"<td><h3>"+s.getRole()+"</h3></td></tr>");
		}
		out.print("</table>");
		} 
	}

