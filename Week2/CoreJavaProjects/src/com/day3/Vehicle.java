package com.day3;

public class Vehicle {
	String vehicleNumber;
	String model;
	double ratePerDay;
	int days;
	
	public Vehicle(String vehicleNumber, String model, double ratePerDay, int days) {
		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.ratePerDay = ratePerDay;
		this.days = days;
	}
	
	public double calculateRent() {
		return ratePerDay * days;
	}
	
	public void display() {
		System.out.println(vehicleNumber + " | " + model + " | " + ratePerDay + " | " + days);
	}
}
