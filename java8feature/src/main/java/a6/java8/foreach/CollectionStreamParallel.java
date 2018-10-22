package a6.java8.foreach;

import java.util.ArrayList;
import java.util.List;

public class CollectionStreamParallel {

	public static void main(String[] args) {
		/*
		 * add cities
		 */
		List<String> cities = new ArrayList<String>();
		for(int i=0;i<1000;i++) {
			cities.add("city-"+i);
		}
		
		/*cities.parallelStream().forEach(new Consumer<String>() {
			public void accept(String name) {
				System.out.println("Anonymous class foreach Value:" + name);
			}

		});*/
		
		/*
		 * iterate using parallel streaming using lambda
		 */
		long start_time= System.currentTimeMillis();
		cities.parallelStream().forEach(city ->System.out.println(city));
		long end_time= System.currentTimeMillis();
		System.out.println("Parralel Total Time Taken:"+(end_time-start_time));
		
	}
	
}
