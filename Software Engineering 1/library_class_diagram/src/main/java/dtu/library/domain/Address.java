package dtu.library.domain;

public class Address {

	private String street;
	private int postcode;
	private String city;

	public Address(String st, int pc, String c) {
		street = st;
		postcode = pc;
		city = c;
	}

	public String getStreet() {
		return street;
	}

	public int getPostcode() {
		return postcode;
	}

	public String getCity() {
		return city;
	}

}
