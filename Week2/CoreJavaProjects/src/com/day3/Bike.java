package com.day3;

public class Bike extends Vehicle {
	public Bike(String vehicleNumber, String model, double ratePerDay, int days) {
		super(vehicleNumber, model, ratePerDay, days);
	}
	
	// child class overrides parent calculate rent
	@Override
	public double calculateRent() {
		double total = ratePerDay * days;
		return total - (total * 0.1);
	}
	
	// child class overrides parent display
	@Override
	public void display() {
		System.out.println("Bike  | " + vehicleNumber + " | " + model + " | " + ratePerDay + " | " + days + " days");
	}
}
