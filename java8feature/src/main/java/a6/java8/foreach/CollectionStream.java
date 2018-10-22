package a6.java8.foreach;

import java.util.ArrayList;
import java.util.List;

public class CollectionStream {
	public static void main(String[] args) {
		/*
		 * add cities
		 */
		List<String> cities = new ArrayList<String>();
		for(int i=0;i<1000;i++) {
			cities.add("city-"+i);
		}
		/*
		 * iterate using streaming using lambda
		 */
		long start_time1= System.currentTimeMillis();
		cities.forEach(city ->System.out.println(city));
		long end_time1= System.currentTimeMillis();
		System.out.println("Total Time Taken:"+(end_time1-start_time1));
	
	}
}
