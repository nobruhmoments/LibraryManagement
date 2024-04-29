package com.sals.library;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Book
{
	private String title;
	private String author;
	private Set<String> genre;
	private String publishDate;
	private String description;
	private BookState state;
	

	public Book()
	{
		
	}
	
	public Book(String title, String author) 
	{
		this.title = title;
		this.author = author;
		this.state = new AvailableBook();
	}
	
	public void createDescription(String newDescription) {
		this.description = newDescription;
	}
	
	public void bookAvailability(boolean Availability)
	{
		if(Availability == true)
		{
			this.state = new AvailableBook();
		}
		else if(Availability == false)
		{
			this.state = new CheckedOut();
		}

	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getAuthor() 
	{
		return author;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public Set<String> getGenres()
	{
		return genre;
	}
	
	public String getDate()
	{
		return publishDate;
	}
	
	public void setTitle(String newTitle)
	{
		this.title = newTitle;
	}
	
	public void setAuthor(String newAuthor)
	{
		this.author = newAuthor;
	}
	
	
	public void setDate(String newDate)
	{
		this.publishDate = newDate;
	}
	
	public void setDescription(String newDescription)
	{
		this.description = newDescription;
	}

}
