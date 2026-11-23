package com.banking;

import java.util.ArrayList;

public class BankAccount {
	private static int new_num = 0;
	protected int cust_id;
	protected int acct_num;
	protected double balance;
	protected String acct_type;
	protected ArrayList<String> transactions = new ArrayList<>();
	
	public BankAccount(int cust_id, String acct_type) {
		this.acct_num = new_num++;
		this.cust_id = cust_id;
		this.acct_type = acct_type;
		this.balance = 0;
	}
	
	public void depositMoney(double amount) {
		balance += amount;
		transactions.add("Deposited $" + amount + ". Balance is now $" + balance + ".");
		System.out.println("Deposited $" + amount + ". Balance is now $" + balance + ".");
	}
	
	public void withdrawMoney(double amount) {
		balance -= amount;
		transactions.add("Withdrew $" + amount + ". Balance is now $" + balance + ".");
		System.out.println("Withdrew $" + amount + ". Balance is now $" + balance + ".");
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
