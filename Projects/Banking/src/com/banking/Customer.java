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

	public static int getNew_id() {
		return new_id;
	}

	public static void setNew_id(int new_id) {
		Customer.new_id = new_id;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
