package com.labfilehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UseEmployee {

	public static void main(String[] args) {
		Employee[] emp = new Employee[5];
		Employee[] emp2 = null;
		
		emp[0] = new Employee(101, "job", 1000);
		emp[1] = new Employee(102, "cob", 1000);
		emp[2] = new Employee(103, "sob", 1000);
		emp[3] = new Employee(104, "lob", 1000);
		emp[4] = new Employee(105, "dob", 1000);

		try (FileOutputStream fos = new FileOutputStream("employees.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileInputStream fis = new FileInputStream("employees.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			oos.writeObject(emp);
			
			emp2 = (Employee[]) ois.readObject();
			for (Employee e : emp2) {
				System.out.println(e);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
