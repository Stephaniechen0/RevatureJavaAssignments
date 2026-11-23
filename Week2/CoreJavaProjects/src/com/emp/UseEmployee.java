package com.emp;

public class UseEmployee {
	static {
		System.out.println("I am static");
	}
	
	public static void main(String[] args) {
		System.out.println("I am main");
		
		Employee empObj = new Employee();
		System.out.println(empObj.id);
		System.out.println(empObj.getName());
		System.out.println(empObj.getSalary());
		
		Employee empObj1 = new Employee(2, "Bob", 8000d);
		System.out.println(empObj1.id);
		System.out.println(empObj1.getName());
		System.out.println(empObj1.getSalary());
		
		Employee empObj2 = new Employee();
		System.out.println(empObj2.id);
		System.out.println(empObj2.getName());
		System.out.println(empObj2.getSalary());
		
		empObj1.setSalary(90000);
		System.out.println(empObj);
		System.out.println(empObj1);
		System.out.println(empObj2);
		
		System.out.println(empObj.incrementSalary());
		
		Employee e1 = new Employee(105, "Joe", 30000);
		Employee e2 = new Employee(105, "Joe", 30000);
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e1 == e2);
		System.out.println(e1.equals(e2));
		
		e1 = null;
		e2 = null;
		
		System.gc();
	}
}
