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




@WebServlet("/updatepass")
public class UpdatePasswordServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regno = req.getParameter("i1");
		String oldpw = req.getParameter("i2");
		String newpw = req.getParameter("i3");
		
		PrintWriter out = resp.getWriter();
		
		StudentsInfoDAO db = new JDBCImpl();
		boolean res = db.updatePassword(Integer.parseInt(regno),oldpw,newpw);
			
		if(res)
		{
		out.print("<h1>Password Updation Succesful</h1>");
		}
		else
		{
			out.print("<h1>Updation Failed</h1>");
		}

		} 
	}

