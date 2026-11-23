package com.myinterface;

public class UPIPayment implements Payment{
	@Override
	public void pay(double amount) {
		System.out.println("You have made the payment via UPI of amount " + amount);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
}
