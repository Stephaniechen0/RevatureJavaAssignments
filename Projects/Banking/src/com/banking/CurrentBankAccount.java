package com.banking;

import java.util.ArrayList;

public class CurrentBankAccount {
	private int cust_id;
	private int acct_num;
	private String acct_type;
	private double balance;
	private ArrayList<String> transactions = new ArrayList<>();
	
	public CurrentBankAccount(int cust_id) {
		super();
		this.acct_type = "Current";
	}
	
	public void depositMoney(double amount) {
		balance += amount;
		transactions.add("Deposited $" + amount + ". Balance is now $" + balance +".");
		System.out.println("Deposited $" + amount + ". Balance is now $" + balance +".\n");
	}
	
	public void withdrawMoney(double amount) {
		balance -= amount;
		transactions.add("Withdrew $" + amount + ". Balance is now $" + balance +".");
		System.out.println("Withdrew $" + amount + ". Balance is now $" + balance +".\n");
	}

	public int getCust_id() {
		return cust_id;
	}

	public int getAcct_num() {
		return acct_num;
	}

	public String getAcct_type() {
		return acct_type;
	}

	public double getBalance() {
		return balance;
	}
	
	public ArrayList<String> getTransactions() {
		return transactions;
	}
}
