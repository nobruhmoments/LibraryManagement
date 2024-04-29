package com.sals.library;

public class AvailableBook implements BookState
{

	public AvailableBook()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkout()
	{
		System.out.println("Book checked out successfully");
		
	}

	@Override
	public void returnbook()
	{
		System.out.println("Book returned successfully");
		
	}

	@Override
	public boolean isAvailable()
	{
		return true;
	}

}
