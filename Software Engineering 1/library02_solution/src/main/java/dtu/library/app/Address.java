package dtu.library.app;

/**
 * Address represents a street address constign of a city, street, and post-code.
 *  
 * Address is a so called "value object" which means that, once created,
 * the address should not change. Therefore Address does not have setter operations.
 * If the address of a user changes, one has to
 * create a new Address object.
 * 
 * A value object is equal to another value object if their attributes are equal.
 * This requires to override the equals method defined in Object. And when
 * you redefine the equals method you also need to define the hashCode method.
 * Otherwise data-structures, like HashSet and HashMap, don't work any more.
 * 
 * The rule combining equals and hashCode is:
 * 
 * if a.equals(b) then a.hashCode() == b.hashCode().
 * 
 * The opposite direction does not have to hold.
 * 
 * @author huba
 *
 */
public class Address {

	private String street;
	private int postCode;
	private String city;

	public Address(String street, int postCode, String city) {
		this.street = street;
		this.postCode = postCode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public int getPostCode() {
		return postCode;
	}

	public String getCity() {
		return city;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Address)) {
			return false;
		}
		Address otherAddress = (Address) other;
		return street.equals(otherAddress.getStreet())
				&& city.equals(otherAddress.getCity())
				&& postCode == otherAddress.getPostCode();
	}
	
	@Override
	public int hashCode() {
		return street.hashCode() ^ postCode ^ city.hashCode();
	}
}
