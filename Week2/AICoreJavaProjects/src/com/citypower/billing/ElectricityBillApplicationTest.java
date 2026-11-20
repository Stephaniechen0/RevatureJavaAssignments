package com.citypower.billing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;
import java.io.ByteArrayInputStream;


import org.junit.jupiter.api.Test;

class ElectricityBillApplicationTest {

    @Test
    void testZeroUnits() {
        assertEquals(0.00,
                ElectricityBillApplication.calculateEnergyCharge(0),
                0.001);
    }

    @Test
    void testFirstSlabBoundary() {
        assertEquals(300.00,
                ElectricityBillApplication.calculateEnergyCharge(100),
                0.001);
    }

    @Test
    void testSecondSlabBoundary() {
        assertEquals(1300.00,
                ElectricityBillApplication.calculateEnergyCharge(300),
                0.001);
    }

    @Test
    void testThirdSlabStart() {
        assertEquals(1307.50,
                ElectricityBillApplication.calculateEnergyCharge(301),
                0.001);
    }

    @Test
    void testSurchargeBelowBoundary() {
        assertEquals(0.00,
                ElectricityBillApplication.calculateSurcharge(1997.50),
                0.001);
    }

    @Test
    void testSurchargeAt393Units() {
        assertEquals(0.00,
                ElectricityBillApplication.calculateSurcharge(
                        ElectricityBillApplication.calculateEnergyCharge(393)),
                0.001);
    }

    @Test
    void testSurchargeAboveBoundary() {
        assertEquals(100.25,
                ElectricityBillApplication.calculateSurcharge(2005.00),
                0.001);
    }

    @Test
    void testFixedChargeAtZeroUnits() {
        assertEquals(50.00,
                ElectricityBillApplication.calculateTotal(0.00),
                0.001);
    }

    @Test
    void test400UnitTotal() {
        double energyCharge =
                ElectricityBillApplication.calculateEnergyCharge(400);

        assertEquals(2050.00, energyCharge, 0.001);
        assertEquals(102.50,
                ElectricityBillApplication.calculateSurcharge(energyCharge),
                0.001);
        assertEquals(2202.50,
                ElectricityBillApplication.calculateTotal(energyCharge),
                0.001);
    }
    
    @Test
    void energyChargeForNoConsumptionIncludesNoUnits() {
        assertEquals(0.00,
                ElectricityBillApplication.calculateEnergyCharge(0),
                0.001);
    }

    @Test
    void energyChargeFor80UnitsUsesOnlyTheFirstSlab() {
        assertEquals(240.00,
                ElectricityBillApplication.calculateEnergyCharge(80),
                0.001);
    }

    @Test
    void energyChargeAtTheEndOfTheFirstSlabIs300() {
        assertEquals(300.00,
                ElectricityBillApplication.calculateEnergyCharge(100),
                0.001);
    }

    @Test
    void energyChargeAtTheStartOfTheSecondSlabIs305() {
        assertEquals(305.00,
                ElectricityBillApplication.calculateEnergyCharge(101),
                0.001);
    }

    @Test
    void energyChargeAtTheEndOfTheSecondSlabIs1300() {
        assertEquals(1300.00,
                ElectricityBillApplication.calculateEnergyCharge(300),
                0.001);
    }

    @Test
    void energyChargeAtTheStartOfTheThirdSlabIs1307Point50() {
        assertEquals(1307.50,
                ElectricityBillApplication.calculateEnergyCharge(301),
                0.001);
    }

    @Test
    void surchargeIsZeroJustBelow2000() {
        assertEquals(0.00,
                ElectricityBillApplication.calculateSurcharge(1997.50),
                0.001);
    }

    @Test
    void surchargeIsFivePercentJustAbove2000() {
        assertEquals(100.25,
                ElectricityBillApplication.calculateSurcharge(2005.00),
                0.001);
    }

    @Test
    void totalAtZeroUnitsContainsOnlyTheFixedCharge() {
        assertEquals(50.00,
                ElectricityBillApplication.calculateTotal(0.00),
                0.001);
    }

    @Test
    void totalAt80UnitsContainsEnergyAndFixedCharges() {
        double energy =
                ElectricityBillApplication.calculateEnergyCharge(80);

        assertEquals(290.00,
                ElectricityBillApplication.calculateTotal(energy),
                0.001);
    }

    @Test
    void totalAt394UnitsIncludesTheSurcharge() {
        double energy =
                ElectricityBillApplication.calculateEnergyCharge(394);

        assertEquals(2005.00, energy, 0.001);
        assertEquals(100.25,
                ElectricityBillApplication.calculateSurcharge(energy),
                0.001);
        assertEquals(2155.25,
                ElectricityBillApplication.calculateTotal(energy),
                0.001);
    }

    @Test
    void totalAt400UnitsMatchesTheCompleteBill() {
        double energy =
                ElectricityBillApplication.calculateEnergyCharge(400);

        assertEquals(2050.00, energy, 0.001);
        assertEquals(102.50,
                ElectricityBillApplication.calculateSurcharge(energy),
                0.001);
        assertEquals(2202.50,
                ElectricityBillApplication.calculateTotal(energy),
                0.001);
    }
    
    @Test
    void readNonNegativeIntegerAcceptsValidReading() {
        Scanner scanner = new Scanner(
                new ByteArrayInputStream("1000".getBytes()));

        int result =
                ElectricityBillApplication.readNonNegativeInteger(
                        scanner,
                        "Enter previous meter reading: ");

        assertEquals(1000, result);
        scanner.close();
    }

    @Test
    void readNonNegativeIntegerRejectsNegativeReading() {
        Scanner scanner = new Scanner(
                new ByteArrayInputStream("-10\n1000".getBytes()));

        int result =
                ElectricityBillApplication.readNonNegativeInteger(
                        scanner,
                        "Enter previous meter reading: ");

        assertEquals(1000, result);
        scanner.close();
    }

    @Test
    void readNonNegativeIntegerRejectsTextInput() {
        Scanner scanner = new Scanner(
                new ByteArrayInputStream("abc\n1000".getBytes()));

        int result =
                ElectricityBillApplication.readNonNegativeInteger(
                        scanner,
                        "Enter previous meter reading: ");

        assertEquals(1000, result);
        scanner.close();
    }

    @Test
    void readNonNegativeIntegerRejectsDecimalInput() {
        Scanner scanner = new Scanner(
                new ByteArrayInputStream("1000.50\n1200".getBytes()));

        int result =
                ElectricityBillApplication.readNonNegativeInteger(
                        scanner,
                        "Enter current meter reading: ");

        assertEquals(1200, result);
        scanner.close();
    }

    @Test
    void readNonNegativeIntegerAcceptsZero() {
        Scanner scanner = new Scanner(
                new ByteArrayInputStream("0".getBytes()));

        int result =
                ElectricityBillApplication.readNonNegativeInteger(
                        scanner,
                        "Enter previous meter reading: ");

        assertEquals(0, result);
        scanner.close();
    }

    @Test
    void validReadingsProduceExpectedDifference() {
        int previousReading = 1000;
        int currentReading = 1400;

        long difference =
                (long) currentReading - (long) previousReading;

        assertEquals(400L, difference);
    }

    @Test
    void invalidCurrentReadingIsLowerThanPrevious() {
        int previousReading = 1600;
        int currentReading = 1200;

        assertTrue(currentReading < previousReading);
    }

    @Test
    void maximumIntegerDifferenceDoesNotOverflowWhenUsingLong() {
        int previousReading = 0;
        int currentReading = Integer.MAX_VALUE;

        long difference =
                (long) currentReading - (long) previousReading;

        assertEquals((long) Integer.MAX_VALUE, difference);
    }

    @Test
    void negativeMeterDifferenceIsNotAccepted() {
        int previousReading = 1600;
        int currentReading = 1200;

        long difference =
                (long) currentReading - (long) previousReading;

        assertTrue(difference < 0);
    }
}
