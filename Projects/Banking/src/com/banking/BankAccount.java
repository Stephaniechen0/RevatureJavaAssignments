package com.banking;

import java.util.ArrayList;

public class BankAccount {
	private static int new_num = 0;
	
	private int cust_id;
	private int acct_num;
	private String acct_type;
	private double balance;
	private ArrayList<String> transactions = new ArrayList<>();
	
	public BankAccount(int cust_id, String acct_type) {
		this.acct_num = new_num++;
		this.cust_id = cust_id;
		this.acct_type = acct_type;
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

	public static int getNew_num() {
		return new_num;
	}

	public static void setNew_num(int new_num) {
		BankAccount.new_num = new_num;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getAcct_num() {
		return acct_num;
	}

	public void setAcct_num(int acct_num) {
		this.acct_num = acct_num;
	}

	public String getAcct_type() {
		return acct_type;
	}

	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public ArrayList<String> getTransactions() {
		return transactions;
	}
}
