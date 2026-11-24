package com.myexception;

public class UseException {

	public static void main(String[] args) {
		int[] myArray = {1, 2, 3, 4};
		try {
			System.out.println(myArray[2]);
			System.out.println("in try block");
			
			int x = 10/2;
			
			String name = "Max";
			name = null;
			System.out.println(name.length());
		} catch (ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e) {
			System.out.println("You cannot show the value of array beyond boundary. " + e.getMessage());
		} finally {
			System.out.println("I am going to execute anyways.");
		}
		System.out.println("Program complete");

	}

}
