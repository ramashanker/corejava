package a7.java8.singlton;

public class SimpleSingleton {
	private static SimpleSingleton INSTANCE;
    private Address address;
      

	private SimpleSingleton() {      
		address= new Address("gothenborg", "bogatan", "46302");
    }
     
    public static SimpleSingleton getInstance()  {
        if(INSTANCE == null) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            INSTANCE = new SimpleSingleton();
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
