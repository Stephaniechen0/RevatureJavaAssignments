package comday2;

public class Calculator {
	public static int addition() {
		return 1 + 2;
	}
	
	public static int addition(int a, int b) {
		return a + b;
	}
	
	public static int multiplication() {
		return 3 * 4;
	}
	
	public static int multiplication(int a, int b) {
		return a * b;
	}
	
	public static int division() {
		return 3 / 0;
	}
	
	public static int division(int a, int b) {
		if (b == 0) {
			System.out.println("Division by zero is not allowed");
			return -1;
		}
		return a / b;
	}
	
	public static void main(String[] args) {
		System.out.println(addition());
		System.out.println(addition(0, 0));
		System.out.println(multiplication());
		System.out.println(multiplication(1, 2));
		System.out.println(division());
		System.out.println(division(1, 78));

	}

}
