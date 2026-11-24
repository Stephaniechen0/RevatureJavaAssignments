package com.myexception;

public class UseEmployee {

	public static void main(String[] args) {
		Employee e;
		try {
			e = new Employee(20, "bob", -20392);
		} catch (InvalidSalaryException i) {
			System.out.println(i);
		}

	}

}
