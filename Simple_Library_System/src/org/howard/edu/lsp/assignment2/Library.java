package org.howard.edu.lsp.assignment2;

import java.util.ArrayList;

/**
 * This class stores an entire library with a list of books and methods to return/borrow books and to see available books
 * @author adewalefolorunsho
 *
 */
public class Library {
	private String address;
	private String hours = "Libraries are open daily from 9am to 5pm.";
	private ArrayList<Book> listOfBooks = new ArrayList<>();
	
	/**
	 * updates the library address 
	 * @param libraryAddress -> the user defined library address
	 */
	public Library(String libraryAddress) {
		// Implement the constructor
		this.address = libraryAddress;
	}
	
	/**
	 * add a book to the list of libraries
	 * @param book -> A Book class that is to be added to the list of books in the library
	 */
	public void addBook(Book book) {
		listOfBooks.add(book);
	}
	
	/**
	 * prints the opening hours of the library
	 */
	public void printOpeningHours() {
		System.out.println(hours);
	}
	
	/**
	 * prints the address of the library
	 */
	public void printAddress() {
		System.out.println(address);
	}
	
	/**
	 * prints the available books in the library
	 */
	public void printAvailableBooks() {
		if(listOfBooks.size() == 0) {
			System.out.println("No book in catalog"); 
			return;
		}
		System.out.println("Available Books:");
		for(int i = 0; i < listOfBooks.size(); i++) {
			if(!(listOfBooks.get(i).isBorrowed())) {
				System.out.println(listOfBooks.get(i).getTitle());
			}
		}
	}
	
	/**
	 * updates the 'borrowed' variable to true to indicate that the book has been borrowed
	 * @param bookTitle -> the title of the book that is to be borrowed
	 */
	public void borrowBook(String bookTitle) {
		for(int i = 0; i < listOfBooks.size(); i++) {
			if(listOfBooks.get(i).getTitle().equals(bookTitle)) {
				if(listOfBooks.get(i).isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
					return;
				}else {
					listOfBooks.get(i).borrowed();
					System.out.println("You successfully borrowed " + bookTitle);
					return;
				}
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
	}
	
	/**
	 * updates the 'borrowed' variable to false to indicate that the book has been returned
	 * @param bookTitle
	 */
	public void returnBook(String bookTitle) {
		for(int i = 0; i < listOfBooks.size(); i++) {
			if(listOfBooks.get(i).getTitle().equals(bookTitle)) {
				listOfBooks.get(i).returned();
				System.out.println("You successfully returned " + bookTitle);
				return;
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
	}
	
	public static void main(String[] args) { 
		// Create two libraries 
		Library firstLibrary = new Library("10 Main St."); 
		Library secondLibrary = new Library("228 Liberty St."); 

		// Add four books to the first library 
		firstLibrary.addBook(new Book("The Da Vinci Code")); firstLibrary.addBook(new Book("Le Petit Prince")); 
		firstLibrary.addBook(new Book("A Tale of Two Cities")); firstLibrary.addBook(new Book("The Lord of the Rings")); 

		// Print opening hours and the addresses 
		System.out.println("Library hours:");
		firstLibrary.printOpeningHours(); 
		System.out.println(); 
		System.out.println("Library addresses:"); 
		firstLibrary.printAddress(); 
		System.out.println("Library hours:");
		secondLibrary.printOpeningHours(); 
		System.out.println(); 
		System.out.println("Library addresses:"); 
		secondLibrary.printAddress(); 

		// Try to borrow The Lords of the Rings from both libraries 
		System.out.println("Borrowing The Lord of the Rings:"); firstLibrary.borrowBook("The Lord of the Rings"); 
		firstLibrary.borrowBook("The Lord of the Rings"); secondLibrary.borrowBook("The Lord of the Rings"); 
		System.out.println(); 

		// Print the titles of all available books from both libraries 
		System.out.println("Books available in the first library:"); firstLibrary.printAvailableBooks(); 
		System.out.println(); 
		System.out.println("Books available in the second library:"); secondLibrary.printAvailableBooks(); 
		System.out.println(); 

		// Return The Lords of the Rings to the first library 
		System.out.println("Returning The Lord of the Rings:"); firstLibrary.returnBook("The Lord of the Rings"); 
		System.out.println();
	} 

}

