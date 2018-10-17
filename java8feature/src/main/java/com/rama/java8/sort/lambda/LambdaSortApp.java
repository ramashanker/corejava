package com.rama.java8.sort.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rama.java8.pojo.Person;

public class LambdaSortApp {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(3, "c3"));
		persons.add(new Person(2, "a2"));
		persons.add(new Person(6, "f6"));
		persons.add(new Person(4, "d4"));
		persons.add(new Person(5, "b5"));
		persons.add(new Person(1, "e1"));
		
		Collections.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getPid() - p2.getPid();
			}
		});
		
		Collections.sort(persons, (p1,p2)->p1.getPid()-p2.getPid());
		System.out.println("After sort by id");
		printDetail(persons);
		persons.sort((p1,p2)->p1.getName().compareTo(p2.getName()));
		System.out.println("After sort ny name:");
		printDetail(persons);
		removeDetail(persons,4);
		System.out.println("deletinf before id 4");
		printDetail(persons);
	}
	
	private static void printDetail(List<Person> persons) {
		persons.stream().forEach(p-> System.out.println("id:"+p.getPid()+" Name:"+p.getName()));
	}
	
	private static void removeDetail(List<Person> persons,int id) {
		persons.removeIf(p->(p.getPid()-id)<0);
	}
	
	
}
