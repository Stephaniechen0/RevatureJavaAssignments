package com.myinterface;

public interface Payment {
	public static final double minPayment = 0;
	
	// method signature, declaration
	void pay(double amount);
	void show();
}
