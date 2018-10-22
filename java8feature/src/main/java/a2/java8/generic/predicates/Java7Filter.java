package a2.java8.generic.predicates;

import java.util.ArrayList;
import java.util.List;

import com.rama.java8.pojo.Employee;

public class Java7Filter {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("empid1", "test1", 1000));
		employees.add(new Employee("empid2", "test2", 2000));
		employees.add(new Employee("empid3", "test3", 3000));
		employees.add(new Employee("empid4", "test4", 4000));
		Employee emp = findEmployeeByName(employees, "test3");
		System.out.println(emp.getEmpid() + ":" + emp.getName() + ":" + emp.getSalary());
		Employee emp1 = findEmployeeBySalary(employees, 4000);
		System.out.println(emp1.getEmpid() + ":" + emp1.getName() + ":" + emp1.getSalary());
	}

	/*
	 * Here the basic problem is we are doing logicaly filter operation on different
	 * attribute and its look like redundancy of the code
	 */
	public static Employee findEmployeeByName(List<Employee> employees, String name) {
		for (Employee emp : employees) {
			if (emp.getName().equals(name)) {
				return emp;
			}
		}
		return null;
	}

	public static Employee findEmployeeBySalary(List<Employee> employees, int salary) {
		for (Employee emp : employees) {
			if (emp.getSalary() == salary) {
				return emp;
			}
		}
		return null;
	}

}
