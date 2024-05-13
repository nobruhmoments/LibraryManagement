package com.sals.library;

public class Book {
    private String title;
    private String author;
    private String description;
    private String date;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.description = "";
        this.available = true;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDate() {
        return this.date;
    }
    public String setDate(String date) {
        return this.date = date;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}