package dtu.library.app;

import dtu.library.app.internal.User;

/** 
 * Class UserInfo is an external representation of informations related to a user.
 * LibraryApp internally uses a class called User instead. The reason to have a UserInfo class
 * and a User class with almost the same information is the aliasing problem. 
 * 
 * @author huba
 *
 */
public class UserInfo {

	private String cpr;
	private String name;
	private String email;
	private Address address;

	public UserInfo(String cpr, String name, String email) {
		this.cpr = cpr;
		this.name = name;
		this.email = email;
	}
	
	public UserInfo(User user) {
		this.cpr = user.getCpr();
		this.name = user.getName();
		this.email = user.getEmail();
		this.address = user.getAddress();
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

	public String getCpr() {
		return cpr;
	}

	public Address getAddress() {
		return address;
	}

}
