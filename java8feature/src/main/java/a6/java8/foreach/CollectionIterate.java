package a6.java8.foreach;

import java.util.ArrayList;
import java.util.List;

public class CollectionIterate {
	public static void main(String[] args) {
		/*
		 * add cities
		 */
		List<String> cities = new ArrayList<String>();
		for(int i=0;i<1000;i++) {
			cities.add("city-"+i);
		}
		/*
		 * Iterate over list
		 */
		long start_time=System.currentTimeMillis();
		for (String city : cities) {
			System.out.println(city);
		}
		long end_time=System.currentTimeMillis();
		System.out.println("Total Time taken:"+(end_time-start_time));

	}
}
