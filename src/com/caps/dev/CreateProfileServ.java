package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dao.JDBCImpl;
import com.caps.dao.StudentsInfoDAO;
import com.caps.dto.Student;
import com.mysql.jdbc.Driver;




@WebServlet("/profile")
public class CreateProfileServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regno = req.getParameter("i1");
		String fname = req.getParameter("i2");
		String lname = req.getParameter("i3");
		String pass = req.getParameter("i4");
		
		PrintWriter out = resp.getWriter();
		
		Student s = new Student();
		s.setRegNo(Integer.parseInt(regno));
		s.setFname(fname);
		s.setLname(lname);
		s.setPassword(pass);
		
		StudentsInfoDAO db = new JDBCImpl();
		boolean state = db.createProfile(s);
			
			if(state) {
				out.print("Success in Profile Creation");
			}else {
				out.print("Failed in Profile Creation");
			}

		} 
	}

