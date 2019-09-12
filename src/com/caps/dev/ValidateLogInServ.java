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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validatelogin")
public class ValidateLogInServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] cookie = req.getCookies();
		boolean state =false;
		PrintWriter out = resp.getWriter();
		
		if(cookie!=null)
		{
			for(Cookie c:cookie)
			{
				if(c.getName().equals("cook"))
				{
					state=true;
				}
			}
		}
		else
		{
			out.println("Cookie are disabled");
			return;
		}
		
		String regno = req.getParameter("regno");
		String pass = req.getParameter("passwd");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306/techies_db"
					+ "?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			
			String sql = "select * from students_info"
					+ " where regno=? and password=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(regno));
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				HttpSession session = req.getSession();
				out.print("<h1>Login Successful</h1>");
			}
			else {
				out.print("<h1>Login Failed</h1>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<h1>Something went wrong</h1>");
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
