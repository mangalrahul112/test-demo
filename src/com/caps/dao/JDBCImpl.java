package com.caps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.caps.dto.Student;

public class JDBCImpl implements StudentsInfoDAO
{
	public JDBCImpl()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	private static final String DBURL="jdbc:mysql://localhost:3306/techies_db"
			+ "?user=root&password=root";
	
	@Override
	public boolean createProfile(Student s)
	{
		String sql = "INSERT INTO students_info "
				+ " VALUES(?,?,?,?)";
		try(Connection con =DriverManager.getConnection(DBURL);
			PreparedStatement pstmt = con.prepareStatement(sql)){
			Class.forName("com.mysql.jdbc.Driver");
			
			pstmt.setInt(1,s.getRegNo());
			pstmt.setString(2,s.getFName());
			pstmt.setString(3,s.getLName());
			pstmt.setString(4,s.getPassword());
			
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(ClassNotFoundException| SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Student searchByID(int regno)
	{
		String sql = "select * from students_info"
				+ " where regno=?";
		try(Connection con =DriverManager.getConnection(DBURL);
			PreparedStatement pstmt = con.prepareStatement(sql)
			)
		{
			Class.forName("com.mysql.jdbc.Driver");
			Student s = new Student();
			pstmt.setInt(1,regno);
			try(ResultSet rs =pstmt.executeQuery())
			{

				if(rs.next())
				{
					
					s.setRegNo(rs.getInt("regno"));
					s.setFname(rs.getString("firstname"));
					s.setLname(rs.getString("lastname"));
					s.setPassword( rs.getString("password"));
					
			}
			
				return s;

			}

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public Student searchByID(int regno,String pass)
	{
		String sql = "select * from students_info si,roles_info ri"
				+ " where si.regno=ri.regno and si.regno=? and si.password=?";
		try(Connection con =DriverManager.getConnection(DBURL);
			PreparedStatement pstmt = con.prepareStatement(sql)
			)
		{
			
			Student s = new Student();
			pstmt.setInt(1,regno);
			pstmt.setString(2,pass);
			try(ResultSet rs =pstmt.executeQuery())
			{

				if(rs.next())
				{
					
					s.setRegNo(rs.getInt("regno"));
					s.setFname(rs.getString("firstname"));
					s.setLname(rs.getString("lastname"));
					s.setPassword( rs.getString("password"));
					s.setRole(rs.getString("role"));
					
			}
			
				return s;

			}

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean deleteProfile(int regno, String Password)
	{
		String sql = "Delete from students_info "
				+ " where regno=? and password=?";
		try(Connection con =DriverManager.getConnection(DBURL);
				PreparedStatement pstmt = con.prepareStatement(sql)
				)
			{
				Class.forName("com.mysql.jdbc.Driver");
				pstmt.setInt(1,regno);
				pstmt.setString(2,Password);
				int count = pstmt.executeUpdate();
				if(count>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		catch(ClassNotFoundException| SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updatePassword(int regno, String oldpw, String newpw)
	{
		String sql = "update students_info set password=? where regno=? and password=?";
		try(Connection con =DriverManager.getConnection(DBURL);
				PreparedStatement pstmt = con.prepareStatement(sql)
				)
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				pstmt.setString(1,newpw);
				pstmt.setInt(2,regno);
				pstmt.setString(3,oldpw);
				int count = pstmt.executeUpdate();
				if(count>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		catch(ClassNotFoundException| SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public ArrayList<Student> viewAllStudents() {
		ArrayList<Student> student = new ArrayList<Student>();
		String sql = "select * from students_info si,roles_info ri"
				+ " where si.regno=ri.regno";
		try(Connection con =DriverManager.getConnection(DBURL);
			Statement stmt = con.createStatement()
			)
		{
			
			
			try(ResultSet rs =stmt.executeQuery(sql))
			{

				while(rs.next())
				{
					Student s = new Student();
					s.setRegNo(rs.getInt("regno"));
					s.setFname(rs.getString("firstname"));
					s.setLname(rs.getString("lastname"));
					s.setPassword( rs.getString("password"));
					s.setRole(rs.getString("role"));
					student.add(s);
			}
				return student;
			}

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public int getCount() {
		String sql = "select * from ReqCount";
		
		try(Connection con =DriverManager.getConnection(DBURL);
			Statement stmt = con.createStatement()
			)
		{
			
			try(ResultSet rs =stmt.executeQuery(sql))
			{

				if(rs.next())
				{
					
					int c =rs.getInt("count");
					return c;
					
			}
			
				

			}

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return 0;
		
	}

	@Override
	public boolean updateCount(int num) {
		String sql = "update ReqCount set count=? where count=?";
		try(Connection con =DriverManager.getConnection(DBURL);
				PreparedStatement pstmt = con.prepareStatement(sql)
				)
			{
				
				
				
				pstmt.setInt(1,getCount()+num);
				pstmt.setInt(2,getCount());
				int count = pstmt.executeUpdate();
				if(count>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

}

