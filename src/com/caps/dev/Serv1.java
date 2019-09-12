package com.caps.dev;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/serv1")
public class Serv1 extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("Got a Req [Serv1]");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/serv2");
			System.out.println("Forwarding the Req to Serv2");
			dispatcher.forward(req, resp);
		}
}
