package com.rama.java.generics;

import java.awt.Color;
import java.util.Random;

import com.rama.java8.pojo.Person;

public class MyCalssApp {
	private static Random random = new Random();

	public static void main(String[] args) {
		MyClass<String, Integer> myclass = new MyClass<String, Integer>("Rama", 10);
		myclass.print();
		Person p1 = new Person(1, "Test1");
		Person p2 = new Person(2, "Test2");
		Person p3 = new Person(3, "Test3");
		Person p4 = new Person(4, "Test4");
		Person p5 = new Person(5, "Test5");
		Person[] persons = { p1, p2, p3, p4, p5 };
		Person p = myMethod(persons);
		System.out.println("PID:" + p.getPid() + " NAME:" + p.getName());
		String[] stringData = { "str1", "str2", "str3", "str4" };
		System.out.println(myMethod(stringData));
		Color[] clours= {Color.BLACK,Color.RED,Color.BLUE};
		System.out.println(myMethod(clours));
	}

	public static <T> T myMethod(T[] dataArray) {
		return (dataArray[randomIndex(dataArray)]);
	}

	private static int randomIndex(Object[] array) {
		return (random.nextInt(array.length));
	}
}
