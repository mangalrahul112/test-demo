package com.caps.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/testServ1", 
		initParams= {@WebInitParam(name="username",value="admin"),
				@WebInitParam(name="passwd",value="admin")})
public class TestServlet1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		ServletContext ctx = getServletContext();
		String email = ctx.getInitParameter("email");

		ServletConfig config = getServletConfig();

		String username = config.getInitParameter("username");
		String passwd = config.getInitParameter("passwd");

		PrintWriter out = resp.getWriter();
		out.println("<h1> The Current Date is: "+new Date());
		out.print("<h1>Email: " + email + "</h1>");
		out.print("<h1>Username: " + username + "</h1>");
		out.print("<h1>Password: " + passwd + "</h1>");
	}

}