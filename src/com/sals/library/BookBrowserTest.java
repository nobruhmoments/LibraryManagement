package com.sals.library;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class BookBrowserTest {

    @Test
    public void testAddBook() {
        BookBrowser browser = new BookBrowser();

        // Add a book
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        book.setDescription("A novel about the American Dream");
        browser.addBook(book);

        // Check if the catalog contains the added book
        assertEquals(1, browser.getCatalogSize()); // Assuming a method to get catalog size

        // Add another book
        Book anotherBook = new Book("To Kill a Mockingbird", "Harper Lee");
        anotherBook.setDescription("A classic novel exploring racial injustice");
        browser.addBook(anotherBook);

        // Check if the catalog contains both books
        assertEquals(2, browser.getCatalogSize()); // Assuming a method to get catalog size
    }

    @Test
    public void testDisplayCatalog() {
        BookBrowser browser = new BookBrowser();

        // Add some sample books
        browser.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        browser.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        // Test displaying the catalog (should not throw exceptions)
        browser.displayCatalog();
    }
}