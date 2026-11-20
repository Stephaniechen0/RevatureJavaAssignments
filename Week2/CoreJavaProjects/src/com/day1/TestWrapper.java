package com.day1;

public class TestWrapper {
	public static void main(String[] args) {
		Integer age = 20;
		Double price = 5.00;
		Character grade = 'A';
		Boolean active = true;
		System.out.println(age);
		System.out.println(price);
		System.out.println(grade);
		System.out.println(active);
		
		int x = 210;
		Integer y = x;
		System.out.println(y);
		
		int z = age.intValue();	
		System.out.println(z);

		double p = price.doubleValue();
		System.out.println(p);
		
		String num = "100";
		int amount = Integer.parseInt(num);
		System.out.println(amount);
	}
}
