package com.rama.corejava.foreach.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ParallelStream {

	public static void main(String[] args) {
		/*
		 * add cities
		 */
		List<String> cities = new ArrayList<String>();
		cities.add("delhi");
		cities.add("kolkata");
		cities.add("bangalore");
		cities.add("mumbai");
		cities.add("chennai");
		cities.add("patna");
		cities.add("ranchi");
		cities.add("lakhnow");
		cities.add("shimla");
		cities.add("bhopal");
		cities.add("raipur");
		cities.add("hyderabad");
		
		for(String city:cities) {
			System.out.println(city);
		}
		
		cities.parallelStream().forEach(new Consumer<String>() {
			public void accept(String name) {
				System.out.println("Anonymous class foreach Value:" + name);
			}

		});

		/*
		 * iterate using parallel streaming using lambda
		 */
		cities.parallelStream().forEach(city ->System.out.println("Lambda:"+city));
	}
}
