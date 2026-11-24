package com.reflection;

import java.lang.reflect.Method;

public class UseReflection {
	public static void main(String[] args) {
		Employee emp = new Employee();
		Class<?> cls = emp.getClass();
		// Display class information
        System.out.println("Class Name: " + cls.getName());
        System.out.println("Class Simple Name: " + cls.getSimpleName());
        System.out.println("Package Name: " + cls.getPackageName());
        System.out.println("Interface: " + cls.isInterface());
        Method[] ms = cls.getMethods();
        for (java.lang.reflect.Method m : ms) {
        	System.out.println(m.toString());
        }
        
	}
}
