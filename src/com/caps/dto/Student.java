package com.caps.dto;

public class Student 
{
	private int regno;
	private String fname;
	private String lname;
	private String password;
	private String role;
	public void setRegNo(int regno)
	{
		this.regno=regno;
	}
	public void setFname(String fname)
	{
		this.fname=fname;
	}
	public void setLname(String lname)
	{
		this.lname=lname;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setRole(String role)
	{
		this.role=role;
	}
	public int getRegNo()
	{
		return this.regno;
	}
	public String getFName()
	{
		return this.fname;
	}
	public String getLName()
	{
		return this.lname;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String getRole()
	{
		return this.role;
	}
	@Override
	public String toString() {
		return "Student [regno=" + regno + ", fname=" + fname + ", lname=" + lname + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
	
}
