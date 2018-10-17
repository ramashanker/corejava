package com.rama.java8.sort;

import java.util.Comparator;

import com.rama.java8.pojo.Person;

public class SortById implements Comparator<Person>{

	@Override
	public int compare(Person a, Person b) {
		
		return a.getPid()-b.getPid();
	}

}
