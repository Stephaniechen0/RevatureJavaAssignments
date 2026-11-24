package com.labfilehandling;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int empId;
	String empName;
	String department;
	double salary;
	
	public Employee(int id, String name, double salary) {
		this.empId = id;
		this.empName = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return this.empId + " | " +  this.empName + " | $" + this.salary;
	}
}
