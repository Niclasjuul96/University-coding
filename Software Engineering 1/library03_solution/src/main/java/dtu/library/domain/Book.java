package dtu.library.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

import dtu.library.dto.BookInfo;

/**
 * This class represents a book with title, author, and signature, where
 * signature is a unique key used by the librarian to identify the book. Very
 * often it is composed of the first letters of the authors plus the year the
 * book was published.
 * 
 * @author Hubert
 *
 */
public class Book {
	
	private static final int FINE = 100;
	private static final int MAX_NUMBER_OF_DAYS = 4 * 7;

	private String title;
	private String author;
	private String signature;
	private Calendar dueDate;

	public Book(String title, String author, String signature) {
		this.title = title;
		this.author = author;
		this.signature = signature;
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

	/**
	 * 
	 * @param searchText
	 * @return returns true if the searchText appears as substring in either title,
	 *         author, or signature field.
	 */
	public boolean match(String searchText) {
		return signature.contains(searchText) || title.contains(searchText) || author.contains(searchText);
	}

	public void setDueDateFromBorrowDate(Calendar borrowDate) {
		setDueDate(new GregorianCalendar());
		getDueDate().setTime(borrowDate.getTime());
		getDueDate().add(Calendar.DAY_OF_YEAR, getMaxBorrowDays());
	}

	protected int getMaxBorrowDays() {
		return MAX_NUMBER_OF_DAYS;
	}

	double getFine() {
		return FINE;
	}

	public BookInfo asMediumInfo() {
		return new BookInfo(this.getTitle(),this.getAuthor(),this.getSignature());
	}

	boolean isOverdue(Calendar currentDate) {
		// Precondition: isOverdue is only called for books that
		// are borrowed and thus have their dueDate set
		// The assert statement will not have full condition coverage, as the
		// precondition should never fail. If the precondition fails, a client has made
		// a mistake, i.e., the program has a bug.
		assert getDueDate() != null;
		return currentDate.after(getDueDate());
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	private void setDueDate(Calendar dueDate) {
		assert dueDate != null;
		this.dueDate = dueDate;
	}

}
