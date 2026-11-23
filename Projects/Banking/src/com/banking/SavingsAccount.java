package com.banking;

import java.util.ArrayList;

public class SavingsAccount extends BankAccount {	
	public SavingsAccount(int cust_id, String acct_type) {
		super(cust_id, acct_type);
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
