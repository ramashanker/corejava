package com.rama.java8.pojo;

public class Employee {
	String empid;
	String name;
	int salary;
	public Employee(String empid, String name, int salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}
	public String getEmpid() {
		return empid;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	
}
