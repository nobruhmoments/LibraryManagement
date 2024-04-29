package com.sals.library;

public class User
{
	private String userName = "Guest";
	private String email;
	private String password;
	private String id = "0";
	

	public User()
	{
		
	}
	
	public static User createnewUser(String newUserName, String newEmail, String newPassword, String newID) 
	{
		User newUser = new User();
		if(newUserName == "Guest")
		{
			return null;
		}
		else {
			newUser.userName = newUserName;
		}
		newUser.email = newEmail;
		newUser.password = newPassword;
		newUser.id = newID;
		
		return newUser;
	}
	
	public String getUser()
	{
		return this.userName;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	

}
