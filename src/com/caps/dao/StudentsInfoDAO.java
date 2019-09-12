package com.caps.dao;

import java.util.ArrayList;

import com.caps.dto.Student;

public interface StudentsInfoDAO
{
	public boolean createProfile(Student s);
	public Student searchByID(int regno);
	public Student searchByID(int regno,String password);
	public boolean deleteProfile(int regno,String Password);
	public boolean updatePassword(int regno,String oldpw,String newpw);
	public ArrayList<Student> viewAllStudents();
	
	public int getCount();
	public boolean updateCount(int c);
}
