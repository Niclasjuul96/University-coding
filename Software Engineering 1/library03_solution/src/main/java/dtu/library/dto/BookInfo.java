package dtu.library.dto;

import dtu.library.domain.Book;

/**
 * This class represents a book with title, author, and signature, where
 * signature is a unique key used by the librarian to identify the book. Very
 * often it is composed of the first letters of the authors plus the year the
 * book was published.
 * 
 * @author Hubert
 *
 */
public class BookInfo {
	private String title;
	private String author;
	private String signature;

	public BookInfo(String title, String author, String signature) {
		this.title = title;
		this.author = author;
		this.signature = signature;
	}
	
	public Book asBook() {
		return new Book(this.getTitle(), this.getAuthor(), this.getSignature());
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getSignature() {
		return signature;
	}

}
