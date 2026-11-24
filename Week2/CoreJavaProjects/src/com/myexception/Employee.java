package com.myexception;

public class Employee {
	int id;
	String name;
	double salary;
	
	Employee(int id, String name, double salary) throws InvalidSalaryException {
		this.id = id;
		this.name = name;
		if (salary < 0) {
			throw new InvalidSalaryException("You may not enter salary < 0. ");
		}
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee | id=" + id + ", name=" + name + ", salary=" + salary;
	}
}
