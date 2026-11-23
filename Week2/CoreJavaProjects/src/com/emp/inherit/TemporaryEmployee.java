package com.emp.inherit;

public class TemporaryEmployee extends Employee {
	private int workingDays;
	private double perDayRate;
	
	public TemporaryEmployee(int id, String name, double salary, int workingDays, double perDayRate) {
		super(id, name, salary);
		this.workingDays = workingDays;
		this.perDayRate = perDayRate;
	}
	
	@Override
	public double calculateSalary() {
		return salary + (workingDays * perDayRate);
	}
	
	@Override
	public String toString() {
		return super.toString() + " | " + this.workingDays + " | " + this.perDayRate;
	}
	
	@Override
	public void display() {
		System.out.println(this.id + " | " +  this.name + " | $" + this.salary + " | " + this.workingDays + " | " + this.perDayRate);
	}
}
