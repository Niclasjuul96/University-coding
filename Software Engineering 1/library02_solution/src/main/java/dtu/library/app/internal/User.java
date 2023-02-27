package dtu.library.app.internal;

import java.util.ArrayList;
import java.util.List;

import dtu.library.app.Address;
import dtu.library.app.Book;
import dtu.library.app.TooManyBooksException;
import dtu.library.app.UserInfo;

public class User {

	private String cpr;
	private String name;
	private String email;
	private Address address;
	private List<Book> borrowedBooks = new ArrayList<>();

	public User(String cpr, String name, String email) {
		this.cpr = cpr;
		this.name = name;
		this.email = email;
	}

	/*
	 * Create a new User object from an existing UserInfo object. It is okay to
	 * share the address as Address is implemented as a value object. Strings are
	 * also treated as value objects in Java.
	 */
	public User(UserInfo user) {
		this.cpr = user.getCpr();
		this.name = user.getName();
		this.email = user.getEmail();
		this.address = user.getAddress();
	}

	public UserInfo asUserInfo() {
		UserInfo ui = new UserInfo(cpr, name, email);
		ui.setAddress(address);
		return ui;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void borrowBook(Book book) throws TooManyBooksException {
		if (borrowedBooks.size() >= 10) {
			throw new TooManyBooksException("Can't borrow more than 10 books");
		}
		borrowedBooks.add(book);
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void returnBook(Book book) throws Exception {
		if (!borrowedBooks.contains(book)) {
			throw new Exception("book is not borrowed by the user");
		}
		borrowedBooks.remove(book);
	}

	public String getCpr() {
		return cpr;
	}

	public Address getAddress() {
		return address;
	}

	public boolean hasBorrowed(Book book) {
		return borrowedBooks.contains(book);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof User)) {
			return false;
		}
		User user = (User) obj;
		return this.cpr.equals(user.getCpr()) && this.name.equals(user.getName()) && this.email.equals(user.getEmail())
				&& ((this.address == null && user.getAddress() == null) || address.equals(user.getAddress()));
	}
	
	@Override
	public int hashCode() {
		return cpr.hashCode() ^ name.hashCode() ^ email.hashCode() ^ address.hashCode();
	}

}
