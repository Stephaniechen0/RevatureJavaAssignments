package com.smartstore.billing;

import java.util.Scanner;

public class SalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter Basic Salary: ₹");
        double basicSalary = scanner.nextDouble();

        calculateAndDisplaySalary(employeeId, employeeName, basicSalary);

        scanner.close();
    }

    public static void calculateAndDisplaySalary(
            int employeeId,
            String employeeName,
            double basicSalary) {

        double hra = calculateHRA(basicSalary);
        double da = calculateDA(basicSalary);
        double grossSalary = basicSalary + hra + da;
        double professionalTax = calculateProfessionalTax(grossSalary);
        double netSalary = grossSalary - professionalTax;

        System.out.println("\n========== Employee Salary Details ==========");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.printf("Basic Salary: ₹%.2f%n", basicSalary);
        System.out.printf("HRA (20%%): ₹%.2f%n", hra);
        System.out.printf("DA (10%%): ₹%.2f%n", da);
        System.out.printf("Gross Salary: ₹%.2f%n", grossSalary);
        System.out.printf("Professional Tax: ₹%.2f%n", professionalTax);
        System.out.printf("Net Salary: ₹%.2f%n", netSalary);
        System.out.println("=============================================");
    }

    public static double calculateHRA(double basicSalary) {
        return basicSalary * 0.20;
    }

    public static double calculateDA(double basicSalary) {
        return basicSalary * 0.10;
    }

    public static double calculateProfessionalTax(double grossSalary) {
        if (grossSalary > 20000) {
            return 200.00;
        } else {
            return 0.00;
        }
    }
}
