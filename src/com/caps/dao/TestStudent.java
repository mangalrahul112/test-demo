package com.caps.dao;

import com.caps.dto.Student;

public class TestStudent 
{
	public static void main(String[] args)
	{
		StudentsInfoDAO si = new JDBCImpl();
		Student s = new Student();
		
		s.setRegNo(92);
		s.setFname("Nine");
		s.setLname("One");
		s.setPassword("root");
		
		boolean state = si.createProfile(s);
		if(state)
		{
			System.out.println("Profile Created");
		}
		else
		{
			System.out.println("Failed in Profile Creation");
		}
		
		 s  = si.searchByID(5);
		System.out.println(s);
		
	boolean state1 = si.deleteProfile(92,"root");
		if(state1)
		{
			System.out.println("Delete Successful");
		}
		else
		{
			System.out.println("Failed in Deletion");
		}
		
		boolean state2 = si.updatePassword(77,"reet","root");
		if(state2)
		{
			System.out.println("Change Successful");
		}
		else
		{
			System.out.println("Failed in Change");
		}
		
	}

}
