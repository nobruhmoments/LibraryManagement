package com.sals.library;

public interface BookState
{
	void checkout();
	void returnbook();
	boolean isAvailable();
	
}
