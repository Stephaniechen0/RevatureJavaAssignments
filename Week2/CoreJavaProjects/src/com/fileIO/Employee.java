package com.fileIO;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable{
	static {
		System.out.println("I am static from Employee");
	}
	
	double salary;
	int id;
	String name;
	
	static int number = 100;
	
	public Employee() {
		this.id = 1;
		this.name = "Alice";
		this.salary = 11000d;
	}
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Employee(String name, double salary) {
		this.id = number++;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return this.id + " | " +  this.name + " | $" + this.salary;
	}
	
	double incrementSalary() {
		return salary + (salary * 0.2);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id), name, Double.valueOf(salary));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Employee" + id + " is garbage collector.");
	}	
	
	public double calculateSalary() {
		return salary;
	}
	
	public void display() {
		System.out.println(this.id + " | " +  this.name + " | $" + this.salary);
	}
}
