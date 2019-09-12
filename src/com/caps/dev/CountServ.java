package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dao.JDBCImpl;
import com.caps.dao.StudentsInfoDAO;

@WebServlet("/count")
public class CountServ extends HttpServlet{
	private static int count;
	@Override
	public void init() throws ServletException {
		count =0;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		count++;
		PrintWriter out = resp.getWriter();
		out.print("Date is"+new Date());
		
	}
	@Override
	public void destroy() {
		StudentsInfoDAO db = new JDBCImpl();
		db.updateCount(count);
		int c = db.getCount();
		System.out.println("Count is:"+c);
	}
}
