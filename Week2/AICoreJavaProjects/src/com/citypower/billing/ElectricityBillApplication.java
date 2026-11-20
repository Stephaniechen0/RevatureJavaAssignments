package com.citypower.billing;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ElectricityBillApplication {

    // Slab limits
    public static final int FIRST_SLAB_LIMIT = 100;
    public static final int SECOND_SLAB_LIMIT = 300;

    // Slab rates
    public static final double FIRST_SLAB_RATE = 3.00;
    public static final double SECOND_SLAB_RATE = 5.00;
    public static final double THIRD_SLAB_RATE = 7.50;

    // Other bill values
    public static final double FIXED_CHARGE = 50.00;
    public static final double SURCHARGE_LIMIT = 2000.00;
    public static final double SURCHARGE_PERCENTAGE = 0.05;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Household Electricity Bill Calculator ===");

        // Accept consumer details
        System.out.print("Enter consumer number: ");
        String consumerNumber = scanner.nextLine();

        System.out.print("Enter consumer name: ");
        String consumerName = scanner.nextLine();

        // Read and validate meter readings
        int previousReading = readNonNegativeInteger(
                scanner, "Enter previous meter reading: ");

        int currentReading = readNonNegativeInteger(
                scanner, "Enter current meter reading: ");

        // Reject invalid meter readings
        if (currentReading < previousReading) {
            System.out.println(
                    "\nError: Current meter reading cannot be less than previous meter reading.");
            scanner.close();
            return;
        }

        // Prevent integer overflow before subtracting readings
        int unitsConsumed;

        if ((long) currentReading - (long) previousReading
                > Integer.MAX_VALUE) {
            System.out.println(
                    "\nError: Meter reading difference is too large.");
            scanner.close();
            return;
        } else {
            unitsConsumed = currentReading - previousReading;
        }

        // Calculate bill values
        double energyCharge = calculateEnergyCharge(unitsConsumed);
        double surcharge = calculateSurcharge(energyCharge);
        double totalAmount = calculateTotal(energyCharge);

        // Display the complete bill
        printBill(
                consumerNumber,
                consumerName,
                previousReading,
                currentReading,
                unitsConsumed,
                energyCharge,
                surcharge,
                totalAmount);

        scanner.close();
    }

    /*
     * Reads an integer and rejects text, decimals and negative numbers.
     * The method keeps asking until valid input is entered.
     */
    public static int readNonNegativeInteger(
            Scanner scanner, String prompt) {

        while (true) {
            System.out.print(prompt);

            try {
                int value = scanner.nextInt();

                if (value < 0) {
                    System.out.println(
                            "Error: Meter reading cannot be negative.");
                } else {
                    return value;
                }
            } catch (InputMismatchException exception) {
                System.out.println(
                        "Error: Please enter a whole number.");
                scanner.nextLine();
            }
        }
    }

    /*
     * Calculates the energy charge using the slab rates.
     */
    public static double calculateEnergyCharge(int units) {
        double energyCharge = 0.0;

        if (units <= FIRST_SLAB_LIMIT) {
            energyCharge = units * FIRST_SLAB_RATE;
        } else if (units <= SECOND_SLAB_LIMIT) {
            int secondSlabUnits = units - FIRST_SLAB_LIMIT;

            energyCharge = (FIRST_SLAB_LIMIT * FIRST_SLAB_RATE)
                         + (secondSlabUnits * SECOND_SLAB_RATE);
        } else {
            int secondSlabUnits =
                    SECOND_SLAB_LIMIT - FIRST_SLAB_LIMIT;
            int thirdSlabUnits = units - SECOND_SLAB_LIMIT;

            energyCharge = (FIRST_SLAB_LIMIT * FIRST_SLAB_RATE)
                         + (secondSlabUnits * SECOND_SLAB_RATE)
                         + (thirdSlabUnits * THIRD_SLAB_RATE);
        }

        return energyCharge;
    }

    /*
     * Calculates 5% surcharge only when energy charge is above ₹2,000.
     */
    public static double calculateSurcharge(double energyCharge) {
        if (energyCharge > SURCHARGE_LIMIT) {
            return energyCharge * SURCHARGE_PERCENTAGE;
        }

        return 0.0;
    }

    /*
     * Calculates the final amount, including fixed charge and surcharge.
     */
    public static double calculateTotal(double energyCharge) {
        double surcharge = calculateSurcharge(energyCharge);

        return energyCharge + FIXED_CHARGE + surcharge;
    }

    /*
     * Prints the bill using the original layout and formatting.
     */
    public static void printBill(
            String consumerNumber,
            String consumerName,
            int previousReading,
            int currentReading,
            int unitsConsumed,
            double energyCharge,
            double surcharge,
            double totalAmount) {

        System.out.println("\n========== Electricity Bill ==========");
        System.out.println("Consumer Number  : " + consumerNumber);
        System.out.println("Consumer Name    : " + consumerName);
        System.out.println("Previous reading : " + previousReading);
        System.out.println("Current reading  : " + currentReading);
        System.out.println("Units Consumed   : " + unitsConsumed);
        System.out.printf("Energy Charge    : ₹%.2f%n", energyCharge);
        System.out.printf("Fixed Charge     : ₹%.2f%n", FIXED_CHARGE);
        System.out.printf("Surcharge        : ₹%.2f%n", surcharge);
        System.out.printf("Total Amount     : ₹%.2f%n", totalAmount);
        System.out.println("======================================");
    }
}
