package com.sals.library;

import java.util.ArrayList;
import java.util.List;

public class BookBrowser 
{
	private List<Book> catalog;
	

	public BookBrowser()
	{
		this.catalog = new ArrayList<>();
	}
	
	public void addBook(Book book)
	{
		catalog.add(book);
		System.out.println("Book has been added: " + book.getTitle());
	}
	
	public void displayCatalog()
	{
		System.out.println("Library's catalog: ");
		for(Book book: catalog)
		{
			System.out.println("Title: " + book.getTitle());
			System.out.println("Auhtor: "+ book.getAuthor());
			System.out.println("Published: "+ book.getDate());
		}
	}
	
	public List<Book> searchBooks(String keyword)
	{
		List<Book> results = new ArrayList<>();
		keyword = keyword.toLowerCase();
		return results;
	}
	
	public int getCatalogSize()
	{
		return catalog.size();
	}

}
