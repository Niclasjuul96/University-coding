package dtu.library.acceptance_tests;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dtu.library.app.LibraryApp;
import dtu.library.app.OperationNotAllowedException;
import dtu.library.app.TooManyMediaException;
import dtu.library.dto.BookInfo;
import dtu.library.dto.UserInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookSteps {

	private LibraryApp libraryApp;

	private BookInfo book;
	private ErrorMessageHolder errorMessage;
	private List<BookInfo> books;
	private Map<String, BookInfo> bookBySignature = new HashMap<>();
	
	private UserHelper helper;
	private MockDateHolder dateHolder;
	private BookHelper bookHelper;

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
	public BookSteps(LibraryApp libraryApp, ErrorMessageHolder errorMessage, UserHelper helper, MockDateHolder dateHolder, BookHelper bookHelper) {
		this.libraryApp = libraryApp;
		this.errorMessage = errorMessage;
		this.helper = helper;
		this.dateHolder = dateHolder;
		this.bookHelper = bookHelper;
	}

	@Given("there is a book with title {string}, author {string}, and signature {string}")
	public void thereIsABookWithTitleAuthorAndSignature(String title, String author, String signature) throws Exception {
		book = new BookInfo(title,author,signature);
	}
	
	@Given("the book is not in the library")
	public void theBookIsNotInTheLibrary() {
	    assertFalse(libraryApp.containsMediumWithSignature(book.getSignature()));
	}
	
	@Given("a book with signature {string} is in the library")
	public void aBookWithSignatureIsInTheLibrary(String signature) throws Exception {
		if (signature.equals("Beck99")) {
			book = new BookInfo("Extreme Programming", "Kent Beck", signature);
		} else {
			book = new BookInfo("The Cucumber BookInfo for Java", "Seb Rose", signature);
		}
		bookBySignature.put(signature,book);
		bookHelper.addBooksToLibrary(Arrays.asList(book));
	}

	@Given("these books are contained in the library")
	public void theseBooksAreContainedInTheLibrary(List<List<String>> books) throws Exception {
		for (List<String> bookInfo : books) {
			libraryApp.addBook(new BookInfo(bookInfo.get(0), bookInfo.get(1), bookInfo.get(2)));
		}
	}
	
	@When("the book is added to the library")
	public void theBookIsAddedToTheLibrary() throws Exception {
		try {
			libraryApp.addBook(book);
		} catch (OperationNotAllowedException e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the book with title {string}, author {string}, and signature {string} is contained in the library")
	public void theBookWithTitleAuthorAndSignatureIsContainedInTheLibrary(String title, String author, String signature)
			throws Exception {
		assertTrue(libraryApp.containsMediumWithSignature(signature));
	}

	@When("the Cd is added to the library")
	public void theCdIsAddedToTheLibrary() throws Exception {
		try {
			libraryApp.addBook(book);
		} catch (OperationNotAllowedException e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("the Cd with title {string}, author {string}, and signature {string} is contained in the library")
	public void theCdWithTitleAuthorAndSignatureIsContainedInTheLibrary(String title, String author, String signature) throws Exception {
		assertThat(book.getTitle(),is(equalTo(title)));
		assertThat(book.getAuthor(),is(equalTo(author)));
		assertThat(book.getSignature(),is(equalTo(signature)));
		assertTrue(libraryApp.getMediaStream().anyMatch(m -> m.getSignature().equals(book.getSignature())));
	}
	
	@Then("the error message {string} is given")
	public void theErrorMessageIsGiven(String errorMessage) throws Exception {
		assertEquals(errorMessage, this.errorMessage.getErrorMessage());
	}

	@Given("the library has a book with title {string}, author {string}, and signature {string}")
	public void theLibraryHasABookWithTitleAuthorAndSignature(String title, String author, String signature)
			throws Exception {
		BookInfo book = new BookInfo(title, author, signature);
		assertThat(book.getTitle(),is(equalTo(title)));
		assertThat(book.getAuthor(),is(equalTo(author)));
		assertThat(book.getSignature(),is(equalTo(signature)));
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

	@Then("no book is found")
	public void noBookIsFound() throws Exception {
		assertTrue(books.isEmpty());
	}

	@Then("the books with signatures {string} and {string} are found")
	public void theBooksWithSignaturesAndAreFound(String signature1, String signature2) throws Exception {
		assertEquals(2, books.size());
		BookInfo book1 = books.get(0);
		BookInfo book2 = books.get(1);
		assertTrue((book1.getSignature().equals(signature1) && book2.getSignature().equals(signature2))
				|| (book1.getSignature().equals(signature2) && book2.getSignature().equals(signature1)));
	}
	
	@Given("book {string} by {string} with signature {string} is in the library")
	public void bookByWithSignatureIsInTheLibrary(String title, String author, String signature) throws Exception {
		book = new BookInfo(title,author,signature);
	}
	
	@Given("the user has borrowed {int} books")
	public void theUserHasBorrowedBooks(int arg1) throws Exception {
		List<BookInfo> exampleBooks = bookHelper.getExampleBooks(10);
		bookHelper.addBooksToLibrary(exampleBooks);
		for (BookInfo b : exampleBooks) {
			libraryApp.borrowBook(b,helper.getUser());
		}
	}


	@When("the user borrows the book")
	public void theUserBorrowsTheBook() throws Exception {
		try {
			libraryApp.borrowBook(book,helper.getUser());
		} catch (TooManyMediaException e ) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the user borrows the book with signature {string}")
	public void theUserBorrowsTheBookWithSignature(String signature) throws Exception {
		try {
			libraryApp.borrowBook(bookBySignature.get(signature),helper.getUser());
		} catch (Exception e ) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the book is borrowed by the user")
	public void theBookIsBorrowedByTheUser() throws Exception {
		assertThat(libraryApp.userHasBorrowedMedium(helper.getUser(),book),is(true));
	}
	
	@Then("the book is not borrowed by the user")
	public void theBookIsNotBorrowedByTheUser() throws Exception {
		assertThat(libraryApp.userHasBorrowedMedium(helper.getUser(),book),is(false));
	}
	
	@Then("the book with signature {string} is not borrowed by the user")
	public void theBookWithSignatureIsNotBorrowedByTheUser(String signature) throws Exception {
		BookInfo book = bookBySignature.get(signature);
		assertThat(libraryApp.userHasBorrowedMedium(helper.getUser(),book),is(false));
	}
	
	@Given("the user has borrowed a book")
	public void theUserHasBorrowedABook() throws Exception {
		book = new BookInfo("title","author","signature");
		bookHelper.addBooksToLibrary(Arrays.asList(book));
		libraryApp.borrowBook(book,helper.getUser());
	}

	@Given("that the user has borrowed a book")
	public void thatTheUserHasBorrowedABook() throws Exception {
		theUserHasBorrowedABook();
	}

	@Given("the user has to pay a fine")
	public void theUserHasToPayAFine() throws Exception {
		book = new BookInfo("title","author","signature");
		bookHelper.addBooksToLibrary(Arrays.asList(book));
		libraryApp.borrowBook(book,helper.getUser());
		dateHolder.advanceDateByDays(29);
		libraryApp.returnUserMedia(helper.getUser(),book);
		assertTrue(libraryApp.getFineForUser(helper.getUser()) > 0);
	}
	
	@Given("that the user has not borrowed the book")
	public void thatTheUserHasNotBorrowedTheBook() throws Exception {
		book = new BookInfo("title","author","signature");
		bookHelper.addBooksToLibrary(Arrays.asList(book));
	}

	@When("the user returns the book")
	public void theUserReturnsTheBook() throws Exception {
		try {
			libraryApp.returnUserMedia(helper.getUser(),book);
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the user returns the book with signature {string}")
	public void theUserReturnsTheBookWithSignature(String signature) throws Exception {
		try {
			libraryApp.returnUserMedia(helper.getUser(),bookBySignature.get(signature));
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Given("there is a user with one overdue book")
	public void thereIsAUserWithOneOverdueBook() throws Exception {
		libraryApp.registerUser(helper.getUser());
		thatTheUserHasBorrowedABook();
		dateHolder.advanceDateByDays(29);
		assertThat(libraryApp.userHasOverdueMedia(helper.getUser()),is(true));		
	}
	
	@Given("a user has an overdue book")
	public void aUserHasAnOverdueBook() throws Exception {
		UserInfo user = helper.getUser();
		libraryApp.adminLogin("adminadmin");
		libraryApp.registerUser(user);
		libraryApp.adminLogout();
		List<BookInfo> books = bookHelper.getExampleBooks(1);
		bookHelper.addBooksToLibrary(books);
		book = books.get(0);
		libraryApp.borrowBook(book, user);
		dateHolder.advanceDateByDays(29);
		assertThat(libraryApp.userHasOverdueMedia(user),is(true));
	}

	@Given("the user has another overdue book")
	public void theUserHasAnotherOverdueBook() throws Exception {
		List<BookInfo> books = new ArrayList<>();
		books.add(new BookInfo("title","author","signature"));
		bookHelper.addBooksToLibrary(books);
		book = books.get(0);
		libraryApp.borrowBook(book, helper.getUser());
		dateHolder.advanceDateByDays(29);
		assertThat(libraryApp.userHasOverdueMedia(helper.getUser()),is(true));
	}

	@When("the user pays {int} DKK")
	public void theUserPaysDKK(int money) throws Exception {
	    libraryApp.payFine(helper.getUser(),money);
	}

	@Then("the user can borrow books again")
	public void theUserCanBorrowBooksAgain() throws Exception {
		assertThat(libraryApp.canBorrow(helper.getUser()),is(true));
	}
	
	@Then("the user cannot borrow books")
	public void theUserCannotBorrowBooks() throws Exception {
		assertThat(libraryApp.canBorrow(helper.getUser()),is(false));
	}


}
