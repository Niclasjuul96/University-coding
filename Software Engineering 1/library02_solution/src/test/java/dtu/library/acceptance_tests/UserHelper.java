package dtu.library.acceptance_tests;

import dtu.library.app.Address;
import dtu.library.app.UserInfo;

public class UserHelper {
	private UserInfo user;
	
	public UserInfo getUser() {
		if (user == null) {
			user = exampleUser();
		}
		return user;
	}
	
	private UserInfo exampleUser() {
		UserInfo user = new UserInfo("231171-3879","Freddie E. Messina","FreddieEMessina@armyspy.com");
		Address address = new Address("Øksendrupvej 68",1321,"København K");
		user.setAddress(address);
		return user;
	}

	public void setUser(UserInfo userInfo) {
		user = userInfo;
	}
}
