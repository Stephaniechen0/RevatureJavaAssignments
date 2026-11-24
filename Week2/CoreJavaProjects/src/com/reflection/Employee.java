package com.reflection;

public class Employee {
	int id;
	String name;
	double salary;
	
	Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	Employee() {
		
	}
	
	public double calculateSalary() {
		return salary + 1.0;
	}
	
	@Override
	public String toString() {
		return "Employee | id=" + id + ", name=" + name + ", salary=" + salary;
	}
}
