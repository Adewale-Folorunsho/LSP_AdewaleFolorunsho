package org.howard.edu.lsp.assignment2;

/**
 * Serves as a template for the data of each books in a library
 * @author adewalefolorunsho
 *
 */

public class Book { 
	private String title; 
	private boolean borrowed = false;

/**
 * Creates a new Book 
 * @param bookTitle -> the title of the book
 */
	public Book(String bookTitle) {
		this.title = bookTitle;
	} 
	
/**
 * Marks the book as rented 
 */
	public void borrowed() {
		this.borrowed = true;
	}
	
/**
 * Marks the book as not rented 
 */
	public void returned() {
		this.borrowed = false;
	}
	
/**
 * Returns true if the book is rented, false otherwise public 
 * @return if the book has been borrowed
 */
	public boolean isBorrowed() {
		return borrowed;
	} 
	
/**
 * Returns the title of the book public 
 * @return the title of the book
 */
	public String getTitle() {
		return title;
	}
}
