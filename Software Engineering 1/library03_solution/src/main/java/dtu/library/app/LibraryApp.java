package dtu.library.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dtu.library.domain.Book;
import dtu.library.domain.User;
import dtu.library.dto.BookInfo;
import dtu.library.dto.UserInfo;

/**
 * This class represents the business logic associated with the library
 * application.
 * 
 * @author Hubert
 *
 */
public class LibraryApp extends Observable {

	private boolean loggedIn = false;
	private List<Book> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private DateServer dateServer = new DateServer();
	private EmailServer emailServer;
	
	/**
	 * @return true if the administrator is logged in, false otherwise.
	 */
	public boolean adminLoggedIn() {
		return loggedIn;
	}

	/**
	 * Logs in the administrator provided that the correct password is supplied.
	 * 
	 * @param password
	 * @return true if the administrator could be logged in, false otherwise.
	 */
	public boolean adminLogin(String password) {
		loggedIn = password.equals("adminadmin");
		setChanged();
		notifyObservers();
		return loggedIn;
	}

	/**
	 * Adds a book to the library, so that it can be searched and borrowed. Only the
	 * administrator can do this. Thus, the administrator has to be logged in.
	 * 
	 * @param book,
	 *            the book to be added
	 * @throws OperationNotAllowedException
	 *             if the administrator is not logged in
	 */
	public void addBook(BookInfo book) throws OperationNotAllowedException {
		checkAdministratorLoggedIn();
		books.add(book.asBook());
	}

	public Stream<Book> getMediaStream() {
		return books.stream();
	}

	/**
	 * Search for a set of mediums by text. The text can be any substring of either
	 * the title, the author, and the signature.
	 * 
	 * @param searchText
	 * @return a list of mediums containing the searchText in either title, author,
	 *         and signature
	 */
	public List<BookInfo> search(String searchText) {
		return books.stream()
				.filter(b -> b.match(searchText))
				.map(b -> b.asMediumInfo())
				.collect(Collectors.toList());
	}

	/**
	 * Logs out the administrator.
	 */
	public void adminLogout() {
		loggedIn = false;
		setChanged();
		notifyObservers();
	}

	public void registerUser(UserInfo u) throws Exception {
		checkAdministratorLoggedIn();
		User user = findUser(u);
		if (user != null) {
			throw new Exception("User is already registered");
		}
		users.add(u.asUser());
	}

	public Stream<UserInfo> getUsersStream() {
		return users.stream().map(u -> new UserInfo(u));
	}

	public void setDateServer(DateServer dateServer) {
		this.dateServer = dateServer;
	}

	public void borrowBook(BookInfo b, UserInfo u) throws Exception {
		Book book = findBook(b);
		User user = findUser(u);
		user.borrowMedium(book, dateServer.getDate());
	}

	public double getFineForUser(UserInfo u) {
		User user = findUser(u);
		double fine = user.getFine(dateServer.getDate());
		return fine;
	}

	public boolean userHasOverdueMedia(UserInfo u) {
		User user = findUser(u);
		boolean hasOverdueMedia = user.hasOverdueMedia(dateServer.getDate());
		return hasOverdueMedia;
	}

	public void sendReminder() throws OperationNotAllowedException {
		checkAdministratorLoggedIn();
		Calendar currentDate = dateServer.getDate();
		users.stream()
			.filter(u -> u.hasOverdueMedia(currentDate))
			.forEach(u -> {u.sendEmailReminder(emailServer,currentDate);});
	}

	private void checkAdministratorLoggedIn() throws OperationNotAllowedException {
		if (!adminLoggedIn()) {
			throw new OperationNotAllowedException("Administrator login required");
		}
	}

	public void setEmailServer(EmailServer emailServer) {
		this.emailServer = emailServer;
	}

	public void payFine(UserInfo u, int money) {
		User user = findUser(u);
		user.payFine(money);
	}

	public boolean canBorrow(UserInfo u) {
		User user = findUser(u);
		try {
			user.canBorrow(dateServer.getDate());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void unregister(UserInfo u) throws Exception {
		User user = findUser(u);
		checkAdministratorLoggedIn();
		if (!users.contains(user)) {
			throw new Exception("User not registered");
		}
		if (!user.getBorrowedMedia().isEmpty()) {
			throw new Exception("Can't unregister user: user has still borrowed books/CDs");
		}
		if (user.getFine(dateServer.getDate()) > 0) {
			throw new Exception("Can't unregister user: user has still fines to pay");
		}
		users.remove(user);
	}

	public void returnUserMedia(UserInfo u, BookInfo m) throws Exception {
		User user = findUser(u);
		Book book =findBook(m);
		user.getFine(dateServer.getDate());
		user.returnBook(book);
	}
	
	public boolean userHasBorrowedMedium(UserInfo u, BookInfo m) {
		User user = findUser(u);
		Book book = findBook(m);
		return user.getBorrowedMedia().contains(book);
	}

	private Book findBook(BookInfo mi) {
		return books.stream().filter(m -> m.getSignature().equals(mi.getSignature())).findAny().orElse(null);
	}

	private User findUser(UserInfo ui) {
		return users.stream().filter(u -> u.getCpr().equals(ui.getCpr())).findAny().orElse(null);
	}

	public boolean containsMediumWithSignature(String signature) {
		return getMediaStream().anyMatch(m -> m.getSignature().contentEquals(signature));
	}
}
