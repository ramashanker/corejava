package com.rama.java8.sort;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rama.java8.pojo.Person;

public class SortApp {
	public static void main(String[] args) {
			List<Person> persons=new ArrayList<>();
			persons.add(new Person(3,"c3"));
			persons.add(new Person(2,"a2"));
			persons.add(new Person(6,"f6"));
			persons.add(new Person(4,"d4"));
			persons.add(new Person(5,"b5"));
			persons.add(new Person(1,"e1"));
			
			System.out.println("Unsorted"); 
	        printData(persons);
	       // persons.sort(new SortById()); This utility provided in java8
	        Collections.sort(persons, new SortById()); // This is provided from 
	        System.out.println("After sort by ID:");
	        printData(persons);
	        System.out.println("sort by name:");
	        persons.sort(new SortByName());//java 8 introduced
	        System.out.println("After sort by ID:");
	        printData(persons);
	}

	private static void printData(List<Person> persons) {
		for (int i=0; i<persons.size(); i++) {
		    System.out.println("ID:"+persons.get(i).getPid()+" Name:"+persons.get(i).getName());
		}
	}
}
