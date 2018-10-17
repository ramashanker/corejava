package com.rama.java8.sort.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rama.java8.pojo.Person;

public class AnnonymousSortApp {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(3, "c3"));
		persons.add(new Person(2, "a2"));
		persons.add(new Person(6, "f6"));
		persons.add(new Person(4, "d4"));
		persons.add(new Person(5, "b5"));
		persons.add(new Person(1, "e1"));

		/*
		 * Anonymous way of sorting with id
		 */
		Collections.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getPid() - p2.getPid();
			}
		});
		System.out.println("After sort by Id:");
		print(persons);
		/*
		 * Anonymous way of sort by name
		 */
		Collections.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});
		System.out.println("After sort by Name:");
		print(persons);
	}
	
	public static void print(List<Person> persons) {
		for (int i=0; i<persons.size(); i++) {
            System.out.println("ID:"+persons.get(i).getPid()+" Name:"+persons.get(i).getName());
        }
	}

}
