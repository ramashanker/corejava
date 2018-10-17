package com.rama.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.rama.java8.pojo.Person;

public class MyListStream {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Mahesh"));
		list.add(new Person(2, "Ram"));
		list.add(new Person(3, "Krishna"));
		Consumer<Person> style = (Person p) -> System.out.println("id:" + p.getPid() + ", Name:" + p.getName());
		System.out.println("---Before delete---");
		list.forEach(style);
		Predicate<Person> personPredicate = p -> p.getPid() == 2;
		list.removeIf(personPredicate);
		System.out.println("---After delete---");
		list.forEach(style);
	}
}
