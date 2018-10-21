package com.rama.java8.binary.operator;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import com.rama.java8.pojo.Person;

public class BinaryOperatorApp {
public static void main(String[] args) {
	BinaryOperator<Integer> adder=(n1,n2)->n1+n2;
	int sum =adder.apply(3, 4);
	System.out.println(sum);
	Supplier<Person> supplier=Person::new;
	Person p1=supplier.get();
	System.out.println(p1.getName());
}
}
