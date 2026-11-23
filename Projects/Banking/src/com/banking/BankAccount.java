package com.banking;

import java.util.ArrayList;

public class BankAccount {
	protected static int new_num = 0;
	
	private int cust_id;
	private int acct_num;
	private double balance;
	private ArrayList<String> transactions = new ArrayList<>();
	
	public BankAccount(int cust_id) {
		this.acct_num = new_num++;
		this.cust_id = cust_id;
		this.balance = 0;
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

	public double getBalance() {
		return balance;
	}
	
	public ArrayList<String> getTransactions() {
		return transactions;
	}
}
