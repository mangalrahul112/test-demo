package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext ctx = getServletContext();
		String email = ctx.getInitParameter("email");
		
		ServletConfig config = getServletConfig();
		
		String username = config.getInitParameter("username");
		String passwd = config.getInitParameter("passwd");
		
		PrintWriter out = resp.getWriter();
		out.print("<h1>Email: " + email + "</h1>");
		out.print("<h1>Username: " + username + "</h1>");
		out.print("<h1>Password: " + passwd + "</h1>");

	}
}
