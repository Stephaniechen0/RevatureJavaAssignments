package comday2;

public class TestMath {

	public static void main(String[] args) {
		int a = 7, b = 2;
		System.out.println(a / b);
		System.out.println(a % b);
		System.out.println(a / (double)b);
		System.out.println(-7 % 3);
		
		int i = 5;
		int x = i++;
		int y = ++i;
		
		Math.pow(2, 10);
		Math.sqrt(25);
		Math.abs(-10);
		Math.max(10, 20);
		Math.round(3.5);
		Math.floor(3.5);
		Math.random();
		
//		(int)(Math.random() * 6) + 1;
		
		System.out.println(1 + 2 + "3");
		System.out.println("1" + 2 + 3);
	}

}
