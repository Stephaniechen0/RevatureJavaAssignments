package com.emp.inherit;

public class PermanentEmployee extends Employee{
	private double bonus;
	
	public PermanentEmployee(double bonus) {
		super();
		this.bonus = bonus;
	}
	
	public PermanentEmployee(int id, String name, double salary, double bonus) {
		super(id, name, salary);
		this.bonus = bonus;
	}

	@Override
	public double calculateSalary() {
		return salary + bonus;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | $" + this.bonus;
	}
	
	@Override
	public void display() {
		System.out.println(this.id + " | " +  this.name + " | $" + this.salary + " | $" + this.bonus);
	}
}
