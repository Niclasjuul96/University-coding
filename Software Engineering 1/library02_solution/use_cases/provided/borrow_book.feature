Feature: Borrow Book
	Description: The user borrows a book
	Actors: User
	
Scenario: User borrows book
	Given a book with signature "Beck99" is in the library
	And a user is registered with the library
	When the user borrows the book
	Then the book is borrowed by the user

Scenario: User borrows book more than 10 books
	Given a user is registered with the library
	And the user has borrowed 10 books
	Given a book with signature "Beck99" is in the library
	When the user borrows the book
	Then the book is not borrowed by the user
	And the error message "Can't borrow more than 10 books" is given
	
	