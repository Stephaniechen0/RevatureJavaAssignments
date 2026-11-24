package com.myexception;

public class TestException {
	public static void main(String[] args) {
		int[] myArray = {1, 2, 3, 4};
		try {
			System.out.println(myArray[2]);
			System.out.println("in try block");
			
			int x = 10/2;
			
			String name = "Max";
			name = null;
			System.out.println(name.length());
		} catch (Exception e) {
			System.out.println("Something wrong.");
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("You cannot show the value of array beyond boundary. " + e.getMessage());
//		} catch (ArithmeticException a) {
//			System.out.println("You can't divide by zero. " + a.getMessage());
//		} catch (NullPointerException n) {
//			System.out.println("You can't find length of null. " + n.getMessage());
		} finally {
			System.out.println("I am going to execute anyways.");
		}
		System.out.println("Program complete");
		
	}
}
