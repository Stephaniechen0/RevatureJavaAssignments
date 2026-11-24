package com.myexception;

public class AgeValidation {
	public static void main(String[] args) {
		try {
			checkAge(15);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void checkAge(int age) {
		if (age < 65) {
			throw new IllegalArgumentException("Underage person cannot be processed. ");
		}
		else {
			System.out.println("Valid age. ");
		}
	}
}
