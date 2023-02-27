package dtu.library.acceptance_tests;

import java.util.ArrayList;
import java.util.List;

import dtu.library.app.LibraryApp;
import dtu.library.app.OperationNotAllowedException;
import dtu.library.dto.BookInfo;

public class BookHelper {
	LibraryApp libraryApp;

	public BookHelper(LibraryApp libraryApp) {
		this.libraryApp = libraryApp;
	}

	public void addBooksToLibrary(List<BookInfo> exampleBooks) throws OperationNotAllowedException {
		boolean adminLoggedIn = libraryApp.adminLoggedIn();
		if (!adminLoggedIn) {
			libraryApp.adminLogin("adminadmin");
		}
		for (BookInfo b : exampleBooks) {
			libraryApp.addBook(b);
		}
		if (!adminLoggedIn) {
			libraryApp.adminLogout();
		}
	}

	public List<BookInfo> getExampleBooks(int n) {
		List<BookInfo> books = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			books.add(new BookInfo("title" + i, "author" + i, "signature" + i));
		}
		return books;
	}
	
	public List<BookInfo> addExampleBooks(int n) throws OperationNotAllowedException {
		List<BookInfo> books = getExampleBooks(n);
		addBooksToLibrary(books);
		return books;
	}
}
