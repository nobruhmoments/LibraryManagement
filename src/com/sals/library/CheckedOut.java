package com.sals.library;

public class CheckedOut implements BookState
{

	public CheckedOut()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkout()
	{
		System.out.println("Book is currently checked out");
		
	}

	@Override
	public void returnbook()
	{
		System.out.println("Book returned successfully");
		
	}

	@Override
	public boolean isAvailable()
	{
		return false;
	}

}
