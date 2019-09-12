package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date")
public class MyFirstServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out = resp.getWriter();
		
		/*String firstname = req.getParameter("fname");
		String lastname = req.getParameter("lname");
		String lang[] = req.getParameterValues("lang");
		
		out.println("Http Mehtod is:"+req.getMethod());
		out.println("URL is:"+req.getRequestURL());
		out.println("Protocol is:"+req.getProtocol());
		out.println("Parameter:"+req.getParameter("name"));
		out.println("Parameter Values:"+Arrays.toString(lang));
		out.println("<h1>The Current Date is: "+new Date()+"</h1>");
		out.println("<h1>The Name Is:"+firstname+" "+lastname+"</h1>");*/
		
	}

}
