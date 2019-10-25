package a7.java8.singlton;

public class Address {
	public Address(String city, String street, String zip) {

		this.city = city;
		this.street = street;
		this.zip = zip;
	}

	String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	String street;
	String zip;
}
