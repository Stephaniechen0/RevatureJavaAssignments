package com.banking;

import java.util.ArrayList;

public class BankAccount {
	private static int new_num = 0;
	private static int new_trans = 0;
	int cust_id;
	int acct_num;
	double balance;
	String acct_type;
	ArrayList<Transaction> transactions = new ArrayList<>();
	
	public BankAccount(int cust_id, String acct_type, double balance) {
		this.acct_num = new_num++;
		this.cust_id = cust_id;
		this.acct_type = acct_type;
		this.balance = balance;
	}
	
	public void depositMoney(double amount) {
		balance += amount;
		transactions.add(new Transaction(new_trans++, "Deposit", amount, balance));
		System.out.println(transactions.get(transactions.size() - 1));
	}
	
	public void withdrawMoney(double amount) {
		balance -= amount;
		transactions.add(new Transaction(new_trans++, "Withdrawal", amount, balance));
		System.out.println(transactions.get(transactions.size() - 1));
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getCust_id() {
		return cust_id;
	}
	public void setAcct_num(int acct_num) {
		this.acct_num = acct_num;
	}

	public int getAcct_num() {
		return acct_num;
	}
	
	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}
	
	public String getAcct_type() {
		return acct_type;
	}
		
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
}
