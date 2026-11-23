package com.emp.inherit;

import java.util.Scanner;

public class UseEmployee {

	public static void main(String[] args) {
		PermanentEmployee p1 = new PermanentEmployee(100, "Bob", 90000, 3000);
		System.out.println(p1);
		p1.display();
		System.out.println("Total salary of permanent employee: " + p1.calculateSalary());
		
		TemporaryEmployee t1 = new TemporaryEmployee(199, "Sob", 20900, 12, 199);
		System.out.println(t1);
		System.out.println(t1.calculateSalary());
		
		Employee p2 = new PermanentEmployee(102, "Eve", 123434, 343);
//		Employee t2 = new TemporaryEmployee(102, "Eve", 123434, 12, 1222);
//		p2 = new TemporaryEmployee(102, "Eve", 123434, 12, 1222);
		
		p2.display();
//		t2.display();
		
		PermanentEmployee p3 = (PermanentEmployee) p2;
		PermanentEmployee p4 = p1;
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		System.out.println(id);
		sc.nextLine();
		
		System.out.println("Enter name: ");
		String name= sc.nextLine();
		System.out.println(name);
		
		System.out.println("Enter salary: ");
		double salary = sc.nextDouble();
		System.out.println(salary);
		
		
	}

}
