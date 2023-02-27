package dtu.library.acceptance_tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dtu.library.app.Book;
import dtu.library.app.LibraryApp;
import dtu.library.app.OperationNotAllowedException;
import dtu.library.app.TooManyBooksException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookSteps {

	private LibraryApp libraryApp;

	private Book book;
	private ErrorMessageHolder errorMessage;
	private List<Book> books;
	
	private UserHelper helper;

	/*
	 * Note that the constructor is apparently never called, but there are no null
	 * pointer exceptions regarding that libraryApp is not set. When creating the
	 * BookSteps object, the Cucumber libraries are using that constructor with an
	 * object of class LibraryApp as the default.
	 * 
	 * This also holds for all other step classes that have a similar constructor.
	 * In this case, the <b>same</b> object of class LibraryApp is used as an
	 * argument. This provides an easy way of sharing the same object, in this case
	 * the object of class LibraryApp, among all step classes.
	 * 
	 * This principle is called <em>dependency injection</em>. More information can
	 * be found in the "Cucumber for Java" book available online from the DTU Library.
	 */
	public BookSteps(LibraryApp libraryApp, ErrorMessageHolder errorMessage, UserHelper helper) {
		this.libraryApp = libraryApp;
		this.errorMessage = errorMessage;
		this.helper = helper;
	}

	@Given("there is a book with title {string}, author {string}, and signature {string}")
	public void thereIsABookWithTitleAuthorAndSignature(String title, String author, String signature) throws Exception {
		book = new Book(title,author,signature);
	}

	@Given("the book is not in the library")
	public void theBookIsNotInTheLibrary() {
	    assertFalse(libraryApp.containsBookWithSignature(book.getSignature()));
	}
	
	@Given("these books are contained in the library")
	public void theseBooksAreContainedInTheLibrary(List<List<String>> books) throws Exception {
		for (List<String> bookInfo : books) {
			libraryApp.addBook(new Book(bookInfo.get(0), bookInfo.get(1), bookInfo.get(2)));
		}
	}
	
	@When("the book is added to the library")
	public void bookIsAddedToTheLibrary() {
		try {
			libraryApp.addBook(book);
		} catch (OperationNotAllowedException e) {
			 errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the book with title {string}, author {string}, and signature {string} is contained in the library")
	public void theBookWithTitleAuthorAndSignatureIsContainedLibrary(String title, String author, String signature)
			throws Exception {
		assertEquals(title, book.getTitle());
		assertEquals(author, book.getAuthor());
		assertEquals(signature, book.getSignature());
		assertTrue(libraryApp.containsBook(book));
	}

	@Then("the error message {string} is given")
	public void errorMessageIsProduced(String errorMessage) throws Exception {
		assertEquals(errorMessage, this.errorMessage.getErrorMessage());
	}

	@Given("the library has a book with title {string}, author {string}, and signature {string}")
	public void theLibraryHasABookWithTitleAuthorAndSignature(String title, String author, String signature)
			throws Exception {
		Book book = new Book(title, author, signature);
		libraryApp.addBook(book);
	}

	@When("the user searches for the text {string}")
	public void theUserSearchesForTheText(String searchText) throws Exception {
		books = libraryApp.search(searchText);
	}

	@Then("the book with signature {string} is found")
	public void theBookWithSignatureIsFound(String signature) throws Exception {
		assertEquals(1, books.size());
		assertEquals(signature, books.get(0).getSignature());
	}

	@Then("no books are found")
	public void noBooksAreFound() throws Exception {
		assertTrue(books.isEmpty());
	}

	@Then("the books with signatures {string} and {string} are found")
	public void theBooksWithSignaturesAndAreFound(String signature1, String signature2) throws Exception {
		assertEquals(2, books.size());
		Book book1 = books.get(0);
		Book book2 = books.get(1);
		assertTrue((book1.getSignature().equals(signature1) && book2.getSignature().equals(signature2))
				|| (book1.getSignature().equals(signature2) && book2.getSignature().equals(signature1)));
	}
	
	@Given("a book {string} by {string} with signature {string} is in the library")
	public void bookByWithSignatureIsInTheLibrary(String title, String author, String signature) throws Exception {
		book = new Book(title,author,signature);
		addBookToLibrary(book);
	}
	
	@Given("a book with signature {string} is in the library")
	public void aBookWithSignatureIsInTheLibrary(String signature) throws OperationNotAllowedException {
		book = new Book("Extreme Programming Explained","Kent Beck",signature);
		addBookToLibrary(book);
		
	}

	@Given("the user has borrowed {int} books")
	public void theUserHasBorrowedBooks(int arg1) throws Exception {
		List<Book> exampleBooks = getExampleBooks(10);
		addBooksToLibrary(exampleBooks);
		for (Book b : exampleBooks) {
			libraryApp.borrowBook(helper.getUser().getCpr(), b.getSignature());
		}
	}

	private void addBookToLibrary(Book book) throws OperationNotAllowedException {
		List<Book> books = new ArrayList<>();
		books.add(book);
		addBooksToLibrary(books);
	}
	
	private void addBooksToLibrary(List<Book> exampleBooks) throws OperationNotAllowedException {
		libraryApp.adminLogin("adminadmin");
		for (Book b : exampleBooks) {
			libraryApp.addBook(b);
		}
		libraryApp.adminLogout();
	}

	private List<Book> getExampleBooks(int n) {
		List<Book> books = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			books.add(new Book("title"+i,"author"+i,"signature"+i));
		}
		return books;
	}

	@When("the user borrows the book")
	public void theUserBorrowsTheBook() throws Exception {
		try {
			libraryApp.borrowBook(helper.getUser().getCpr(), book.getSignature());
		} catch (TooManyBooksException e ) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the book is borrowed by the user")
	public void theBookIsBorrwedByTheUser() throws Exception {
		assertThat(libraryApp.userHasBorrowedBook(helper.getUser().getCpr(),book.getSignature()),is(true));
	}
	
	@Then("the book is not borrowed by the user")
	public void theBookIsNotBorrowedByTheUser() throws Exception {
		assertThat(libraryApp.userHasBorrowedBook(helper.getUser().getCpr(), book.getSignature()),is(false));
	}
	
	@Given("that the user has borrowed a book")
	public void thatTheUserHasBorrowedABook() throws Exception {
		book = new Book("title","author","signature");
		addBookToLibrary(book);
		libraryApp.borrowBook(helper.getUser().getCpr(), book.getSignature());
	}
	
	@Given("that the user not borrowed the book")
	public void thatTheUserNotBorrowedTheBook() throws Exception {
		book = new Book("title","author","signature");
		addBooksToLibrary(Arrays.asList(book));
	}

	@When("the user returns the book")
	public void theUserReturnsTheBook() throws Exception {
		try {
			libraryApp.returnBook(helper.getUser().getCpr(),book.getSignature());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
}
