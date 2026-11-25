package com.cts.model;

public class Customer {
	private static int new_id = 0;
	int cust_id;
	String name;
	String email;
	String phone;
	
	public Customer(String name, String email, String phone) {
		this.cust_id = new_id++;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getCust_id() {
		return cust_id;
	}

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
}
