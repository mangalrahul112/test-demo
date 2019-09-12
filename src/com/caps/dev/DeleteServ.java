package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dao.JDBCImpl;
import com.caps.dao.StudentsInfoDAO;

@WebServlet("/del")
public class DeleteServ extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String regno = req.getParameter("regno");
		String pass = req.getParameter("passwd");
		PrintWriter out = resp.getWriter();
		
		StudentsInfoDAO db = new JDBCImpl();
		boolean res = db.deleteProfile(Integer.parseInt(regno),pass);
		
		if(res)
		{
			out.print("<h1>Profile delete Successfully</h1>");
		}
		else
		{
			out.print("<h1>Profile Not deleted</h1>");
		}
	}
}
