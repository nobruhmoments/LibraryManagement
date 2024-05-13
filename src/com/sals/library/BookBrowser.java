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
	
    // Method to update an existing book in the catalog
    public void updateBook(Book updatedBook) {
        for (int i = 0; i < catalog.size(); i++) {
            Book book = catalog.get(i);
            if (book.getTitle().equals(updatedBook.getTitle())) {
                // Update book details
                book.setAuthor(updatedBook.getAuthor());
                book.setDescription(updatedBook.getDescription());
                book.setAvailable(updatedBook.isAvailable());
                // Optionally update other fields as needed
                break; // Stop searching once the book is found and updated
            }
        }
    }

    // Method to retrieve the entire catalog
    public List<Book> getCatalog1() {
        return catalog;
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

    public Book[] getCatalog() {
        // Convert the list of books to an array
        Book[] booksArray = new Book[catalog.size()];
        return catalog.toArray(booksArray);
    }

}
