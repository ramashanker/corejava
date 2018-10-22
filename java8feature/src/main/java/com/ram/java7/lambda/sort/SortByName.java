package com.ram.java7.lambda.sort;

import java.util.Comparator;

import com.rama.java8.pojo.Person;

public class SortByName implements Comparator<Person> {

	@Override
	public int compare(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}

}
