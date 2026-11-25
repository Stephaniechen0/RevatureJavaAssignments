package com.cts.model;

public class Transaction {
	private static int new_num = 0;
	int transID;
	String transType;
	double amount;
	double balance;
	
	public Transaction(int transID, String transType, double amount, double balance) {
		this.transID = transID;
		this.transType = transType;
		this.amount = amount;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Transaction ID: " + transID +
	               "\nType: " + transType +
	               "\nAmount: " + amount +
	               "\nBalance After: " + balance;
	}
}
