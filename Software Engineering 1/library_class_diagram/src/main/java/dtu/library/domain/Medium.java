package dtu.library.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This class represents a medium with title, author, and signature, where
 * signature is a unique key used by the librarian to identify the medium. Very
 * often it is composed of the first letters of the authors plus the year the
 * medium was published.
 * 
 * @author Hubert
 *
 */
public abstract class Medium {
	private String title;
	private String author;

	private String signature;

	private Calendar dueDate;

	protected Medium(String author, String title, String signature) {
		this.signature = signature;
		this.title = title;
		this.author = author;
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

	abstract protected int getMaxBorrowDays();

	abstract protected double getFine();

	public boolean isOverdue(Calendar currentDate) {
		return currentDate.after(getDueDate());
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	private void setDueDate(Calendar dueDate) {
		assert dueDate != null;
		this.dueDate = dueDate;
	}

	public String toString() {
		return getTitle() + " by " + getAuthor();
	}

	public void setDueDateFromBorrowDate(Calendar borrowDate) {
		setDueDate(new GregorianCalendar());
		getDueDate().setTime(borrowDate.getTime());
		getDueDate().add(Calendar.DAY_OF_YEAR, getMaxBorrowDays());
	}
}
