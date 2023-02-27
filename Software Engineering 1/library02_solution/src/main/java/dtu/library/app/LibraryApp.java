package dtu.library.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dtu.library.app.internal.User;


/**
 * This class represents the business logic associated with the library application.
 * @author Hubert
 *
 */
public class LibraryApp {
	
	/*
	 * Internally, the class LibraryApp uses class User instead of UserInfo.
	 */

	private boolean loggedIn = false;
	private List<Book> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();

	/**
	 * @return true if the administrator is logged in, false otherwise.
	 */
	public boolean adminLoggedIn() {
		return loggedIn;
	}

	/**
	 * Logs in the administrator provided that the correct password is supplied.
	 * @param password
	 * @return true if the administrator could be logged in, false otherwise.
	 */
	public boolean adminLogin(String password) {
		loggedIn = password.equals("adminadmin");
		return loggedIn;
	}

	/**
	 * Adds a book to the library, so that it can be searched and borrowed.
	 * Only the administrator can do this. Thus, the administrator has to be logged in.
	 * @param book, the book to be added
	 * @throws OperationNotAllowedException if the administrator is not logged in
	 */
	public void addBook(Book book) throws OperationNotAllowedException {
		Book b = new Book(book);
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		books.add(b);
	}

	/**
	 * Search for a set of books by text. The text can be any substring of 
	 * either the title, the author, and the signature.
	 * @param searchText
	 * @return a list of books containing the searchText in either title, author, and signature
	 */
	public List<Book> search(String searchText) {
//		/* Simple version */
//		List<Book> found = new ArrayList<>();
//		for (Book book : books) {
//			if (book.match(searchText)) {
//				found.add(b.asBookInf());
//			}
//		}
//		return found;
		/* Using Java 8 streams to search */
		return books.stream()
				.filter(b -> b.match(searchText))
				.collect(Collectors.toList());
	}

	/**
	 * Logs out the administrator.
	 */
	public void adminLogout() {
		loggedIn = false;
	}

	public void registerUser(UserInfo u) throws Exception {
		User user = new User(u);
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
		if (users.contains(user)) {
			throw new Exception("User is already registered");
		}
		users.add(user);
	}

	public void borrowBook(String cpr, String signature) throws TooManyBooksException {
		User user = getUserFromCpr(cpr);
		Book book = getBookFromSignature(signature);
		user.borrowBook(book);
	}

	private Book getBookFromSignature(String signature) {
		return books.stream().filter(b -> b.getSignature().equals(signature)).findAny().orElse(null);
	}
	
	private User getUserFromCpr(String cpr) {
		return users.stream().filter(u -> u.getCpr().equals(cpr)).findAny().orElse(null);
	}
	
	public UserInfo getUser(String cpr) {
		return new UserInfo(getUserFromCpr(cpr));
	}

	public boolean userHasBorrowedBook(String cpr, String signature) {
		User user = getUserFromCpr(cpr);
		Book book = getBookFromSignature(signature);
		return user.hasBorrowed(book);
	}

	public boolean containsBook(Book book) {
		return books.stream().anyMatch(b -> b.getSignature().equals(book.getSignature()));
	}

	public void returnBook(String cpr, String signature) throws Exception {
		User user = getUserFromCpr(cpr);
		Book book = getBookFromSignature(signature);
		user.returnBook(book);
	}

	public boolean userIsRegistered(UserInfo user) {
		return getUserFromCpr(user.getCpr()) != null;
	}

	public boolean containsBookWithSignature(String signature) {
		return books.stream().anyMatch(m -> m.getSignature().contentEquals(signature));
	}

}
