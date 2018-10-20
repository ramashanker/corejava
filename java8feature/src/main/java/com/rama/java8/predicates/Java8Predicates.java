package com.rama.java8.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.rama.java8.pojo.Person;

public class Java8Predicates {
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
		Employee emp1 = firstMatchingEmployee(employees, emp -> emp.getEmpid().equals("empid3"));
		System.out.println(emp1.getEmpid() + ":" + emp1.getName() + ":" + emp1.getSalary());
		Employee emp2 = firstMatchingEmployee(employees, emp -> emp.getSalary() > 3000);
		System.out.println(emp2.getEmpid() + ":" + emp2.getName() + ":" + emp2.getSalary());

		/*
		 * Better Approch solution
		 */
		System.out.println("better approch:");
		Employee e=firstMatching(employees, emp->emp.getName().equals("test2"));
		System.out.println(e.getEmpid() + ":" + e.getName() + ":" + e.getSalary());	
		Person p=firstMatching(persons, person->person.getPid()>1);
		System.out.println(p.getName() + ":" + p.getPid());
	}

	/*
	 * Here we have removed redundancy
	 */
	public static Employee firstMatchingEmployee(List<Employee> employees, Predicate<Employee> matchFunction) {
		for (Employee emp : employees) {
			if (matchFunction.test(emp)) {
				return emp;
			}
		}
		return null;
	}
	/*
	 * This is even better we can also generalize Employee to T for any predicates
	 * which will resolve at compile time
	 */

	public static <T> T firstMatching(List<T> employees, Predicate<T> matchFunction) {
		for (T emp : employees) {
			if (matchFunction.test(emp)) {
				return emp;
			}
		}
		return null;
	}
}
