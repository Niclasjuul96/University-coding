package dtu.library.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import dtu.library.domain.Medium;
import dtu.library.domain.User;

/**
 * This class represents the business logic associated with the library
 * application.
 * 
 * @author Hubert
 *
 */
public class LibraryApp  {

	private boolean loggedIn = false;
	private List<Medium> mediumRepository = new ArrayList<>();
	private List<User> userRepository = new ArrayList<>();
	private DateServer dateServer = new DateServer();
	private EmailServer emailServer = new EmailServer();
	
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
		return loggedIn;
	}

	/**
	 * Adds a medium to the library, so that it can be searched and borrowed. Only the
	 * administrator can do this. Thus, the administrator has to be logged in.
	 * 
	 * @param medium,
	 *            the medium to be added
	 * @throws LibraryAppException
	 *             if the administrator is not logged in
	 */
	public void addMedium(Medium medium) throws LibraryAppException {
	}

	/**
	 * Search for a set of mediums by text. The text can be any substring of either
	 * the title, the author, and the signature.
	 * 
	 * @param searchText
	 * @return a list of mediums containing the searchText in either title, author,
	 *         and signature
	 */
	public List<Medium> search(String searchText) {
		return null;
	}

	/**
	 * Logs out the administrator.
	 */
	public void adminLogout() {
		loggedIn = false;
	}

	public void registerUser(User u) throws Exception {
	}

	public void setDateServer(DateServer dateServer) {
		this.dateServer = dateServer;
	}

	public void borrowMedium(Medium m, User u) throws LibraryAppException {
	}

	public double getFineForUser(User u) {
		return 0;
	}

	public void sendReminder() throws LibraryAppException {
	}

	public void setEmailServer(EmailServer emailServer) {
		this.emailServer = emailServer;
	}

	public void payFine(User u, int money) {
	}

	public boolean canBorrow(User u) {
		return false;
	}

	public void unregister(User u) throws Exception {
	}

	public void returnUserMedia(User u, Medium m) throws Exception {
	}
	
}
