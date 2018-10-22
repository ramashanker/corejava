package com.ram1.java8.method.references.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.rama.java8.pojo.Employee;
import com.rama.java8.pojo.Person;

public class GeneralizeFunctionCustomize {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		List<Person> persons = new ArrayList<Person>();
		employees.add(new Employee("empid1", "test1", 1000));
		employees.add(new Employee("empid2", "test2", 2000));
		employees.add(new Employee("empid3", "test3", 3000));
		employees.add(new Employee("empid4", "test4", 4000));
		persons.add(new Person(1, "p1"));
		persons.add(new Person(2, "p2"));
		persons.add(new Person(3, "p3"));
		int sumsalary = mapSum(employees, Employee::getSalary);
		System.out.println(sumsalary);
		int personId = mapSum(persons, Person::getPid);
		System.out.println(personId);
		/*
		 * Here i am passing the implementation for the apply function
		 */
		int sumEmployeeSalaryMinusNumber = mapSum(employees, e -> e.getSalary() - 1000);
		System.out.println(sumEmployeeSalaryMinusNumber);
		/*
		 * String sum will not support int names=transform(persons, Person::getName);
		 */
	}

	/*
	 * The type of problem which it will solve is: have a list of employee and add
	 * up their salaries also common as list of countries and add up their
	 * population list of person and add up their age.
	 */
	public static <T> int mapSum(List<T> value, Function<T, Integer> mapper) {
		int sum = 0;
		for (T entry : value) {
			sum += mapper.apply(entry);
		}
		return sum;
	}
}
