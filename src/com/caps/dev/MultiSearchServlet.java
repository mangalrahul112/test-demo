package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multi")
public class MultiSearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String keyword = req.getParameter("search");
		PrintWriter out = resp.getWriter();
		if(req.getParameter("r1").equals("google"))
		{
			String url = "https://www.google.co.in/search?q="+keyword;
			resp.sendRedirect(url);
		}
		else if(req.getParameter("r1").equals("yahoo"))
		{
			String url = "https://in.search.yahoo.com/search?p="+keyword;
			resp.sendRedirect(url);
		}
		else
		{
			String url = "https://duckduckgo.com/?q="+keyword;
			resp.sendRedirect(url);
		}
		
		
	}
}
