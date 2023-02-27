package dtu.library.acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dtu.library.app.Address;
import dtu.library.app.LibraryApp;
import dtu.library.app.UserInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {
	
	private LibraryApp libraryApp;
	private Address address;
	private ErrorMessageHolder errorMessage;
	private UserHelper helper;
	
	public UserSteps(LibraryApp libraryApp, ErrorMessageHolder errorMessage, UserHelper helper) {
		this.libraryApp = libraryApp;
		this.errorMessage = errorMessage;
		this.helper = helper;
	}
	
	@Given("there is a user with CPR {string}, name {string}, e-mail {string}")
	public void thereIsAUserWithCPRNameEMail(String cpr, String name, String email) throws Exception {
		helper.setUser(new UserInfo(cpr,name,email));
		assertThat(helper.getUser().getCpr(),is(equalTo(cpr)));
		assertThat(helper.getUser().getName(),is(equalTo(name)));
		assertThat(helper.getUser().getEmail(),is(equalTo(email)));
	}
	
	@Given("the user has address street {string}, post code {int}, and city {string}")
	public void theUserHasAddressWithStreetPostCodeAndCity(String street, int postCode, String city) throws Exception {
		address = new Address(street,postCode,city);
		assertThat(address.getStreet(),is(equalTo(street)));
		assertThat(address.getPostCode(),is(equalTo(postCode)));
		assertThat(address.getCity(),is(equalTo(city)));
		helper.getUser().setAddress(address);
		assertThat(helper.getUser().getAddress(),is(sameInstance(address)));
	}
	
	@When("the administrator registers the user")
	public void theAdministratorRegistersTheUser() throws Exception {
		try {
			libraryApp.registerUser(helper.getUser());
		} catch (Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@When("the administrator registers the user again")
	public void theAdministratorRegistersTheUserAgain() throws Exception {
		theAdministratorRegistersTheUser();
	}

	@Then("the user is a registered user of the library")
	public void theUserIsARegisteredUserOfTheLibrary() throws Exception {
		UserInfo ui = libraryApp.getUser(helper.getUser().getCpr());
		
		assertEquals(helper.getUser().getCpr(),ui.getCpr());
		assertEquals(helper.getUser().getName(),ui.getName());
		assertEquals(helper.getUser().getEmail(),ui.getEmail());
		
		assertEquals(helper.getUser().getAddress().getStreet(),ui.getAddress().getStreet());
		assertEquals(helper.getUser().getAddress().getPostCode(),ui.getAddress().getPostCode());
		assertEquals(helper.getUser().getAddress().getCity(),ui.getAddress().getCity());

		assertTrue(libraryApp.userIsRegistered(helper.getUser()));
	}
	
	@Given("a user is registered with the library")
	public void aUserIsRegisteredWithTheLibrary() throws Exception {
		UserInfo user = helper.getUser();
	    libraryApp.adminLogin("adminadmin");
	    libraryApp.registerUser(user);
	    libraryApp.adminLogout();
	}
}

