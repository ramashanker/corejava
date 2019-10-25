package a7.java8.singlton;

public class NoSinglton {
	private static NoSinglton INSTANCE;
	private Address address;

	private NoSinglton() {
		address = new Address("gothenborg", "bogatan", "46302");
	}

	public static NoSinglton getInstance() {

		INSTANCE = new NoSinglton();

		return INSTANCE;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
