package com.banking;

public class Customer {
	private static int new_id = 0;
	private int cust_id;
	private String name;
	private String email;
	private String phone;
	
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
