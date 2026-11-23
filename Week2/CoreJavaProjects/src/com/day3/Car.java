package com.day3;

public class Car extends Vehicle {
	double insurance;
	
	public Car(String vehicleNumber, String model, double ratePerDay, int days, double insurance) {
		super(vehicleNumber, model, ratePerDay, days);
		this.insurance = insurance;
	}
	
	// child class overrides parent calculateRent
	@Override
	public double calculateRent() {
		return (insurance + ratePerDay) * days;
	}
	
	// child class overrides parent display
	@Override
	public void display() {
		System.out.println("Car   | " + vehicleNumber + " | " + model + " | " + ratePerDay + " | " + days + " days");
	}
}
