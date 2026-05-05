package com.ui.pojos;

public class User {

	private String emailAddress;
	private String password;
	private String expectedUserName;
	
	public User(String emailAddress, String password, String expectedName) {
		
		this.emailAddress = emailAddress;
		this.password = password;
		this.expectedUserName = expectedName;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
		
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setExpectedUserName(String expectedUserName)
	{
		this.expectedUserName = expectedUserName;
	}
	
	public String getExpectedUserName()
	{
		return expectedUserName;
	}
	
	public String toString()
	{
		return String.format("emailAddress : %s , password : %s , expectedUserName : %s ", emailAddress , password , expectedUserName);
	}
}
