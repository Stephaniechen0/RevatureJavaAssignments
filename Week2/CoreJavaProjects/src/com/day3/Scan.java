package com.day3;

import java.util.ArrayList;
import java.util.Scanner;

public class Scan {
	private static ArrayList<Vehicle> vehicles = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of vehicles: ");
		int num_vehicles = sc.nextInt();
		sc.nextLine();
		
		int i = 0;
		while (i < num_vehicles) {
			System.out.print("Enter type (1-Car, 2-Bike): ");
			int type = sc.nextInt();
			sc.nextLine();
			
			if (type != 1 || type != 2) {
				System.out.println("Invalid type, must be 1 or 2.");
				continue;
			}
			
			if (type == 1) {
				System.out.print("Enter Vehicle Number: ");
				String num = sc.nextLine();
				System.out.print("Enter Model: ");
				String model = sc.nextLine();
				System.out.print("Enter Rate per Day: ");
				double rate = sc.nextDouble();
				sc.nextLine();
				System.out.print("Enter Days: ");
				int days = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Insurance per Day: ");
				double insurance = sc.nextDouble();
				sc.nextLine();
				
				Car c = new Car(num, model, rate, days, insurance);
				vehicles.add(c);
			}
			else if (type == 2) {
				System.out.print("Enter Vehicle Number: ");
				String num = sc.nextLine();
				System.out.print("Enter Model: ");
				String model = sc.nextLine();
				System.out.print("Enter Rate per Day: ");
				double rate = sc.nextDouble();
				sc.nextLine();
				System.out.print("Enter Days: ");
				int days = sc.nextInt();
				sc.nextLine();
				
				Bike b = new Bike(num, model, rate, days);
				vehicles.add(b);
			}
		}
		
		sc.close();
		
		System.out.println("--- Rental Details ---");
		double total = 0;
		for (Vehicle v : vehicles) {
			v.display();
			total += v.calculateRent();
		}
		System.out.println("Total Rent Collected: " + total);

	}

}
