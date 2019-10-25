package a7.java8.singlton;

public enum EnumSinglton {
	INSTANCE;
	private Address address;

	private EnumSinglton() {
		setAddress(new Address("gothenborg", "bogatan", "46302"));
	}

	public EnumSinglton getInstance() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return INSTANCE;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
