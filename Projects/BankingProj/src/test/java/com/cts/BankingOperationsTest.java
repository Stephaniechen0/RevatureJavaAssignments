package com.cts;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.exception.InvalidAmountException;
import com.cts.exception.NotFoundException;
import com.cts.model.BankAccount;
import com.cts.model.CurrentAccount;
import com.cts.model.Customer;
import com.cts.model.SavingsAccount;

class BankingOperationsTest {

    @Mock
    private BankAccount mockedAccount;

    private BankingManagementSystem system;
    private InputStream originalInput;

    @BeforeAll
    static void setupAll() {
        System.out.println("Starting banking operation tests...");
    }

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        system = new BankingManagementSystem();
        originalInput = System.in;

        BankingManagementSystem.customers.clear();
        BankingManagementSystem.accounts.clear();
    }

    @Test
    void testCustomerCreation() {
        BankingManagementSystem.customers.add(
                new Customer("Alice", "alice@email.com", "1234567890")
        );

        assertEquals(1, BankingManagementSystem.customers.size());
        assertEquals("Alice",
                BankingManagementSystem.customers.get(0).getName());
        assertEquals("alice@email.com",
                BankingManagementSystem.customers.get(0).getEmail());
        assertEquals("1234567890",
                BankingManagementSystem.customers.get(0).getPhone());
    }

    @Test
    void testCreateCurrentAccount() throws Exception {
        Customer customer =
                new Customer("Alice", "alice@email.com", "1234567890");
        BankingManagementSystem.customers.add(customer);

        String input = customer.getCust_id() + "\n"
                + "Current\n"
                + "500\n";

        BankingManagementSystem.scanner =
                new Scanner(new ByteArrayInputStream(input.getBytes()));

        system.createBankAccount();

        assertEquals(1, BankingManagementSystem.accounts.size());
        BankAccount account = BankingManagementSystem.accounts.get(0);

        assertTrue(account instanceof CurrentAccount);
        assertEquals("Current", account.getAcct_type());
        assertEquals(customer.getCust_id(), account.getCust_id());
        assertEquals(500, account.getBalance(), 0.001);
    }

    @Test
    void testCreateSavingsAccount() throws Exception {
        Customer customer =
                new Customer("Bob", "bob@email.com", "9876543210");
        BankingManagementSystem.customers.add(customer);

        String input = customer.getCust_id() + "\n"
                + "Savings\n"
                + "1000\n";

        BankingManagementSystem.scanner =
                new Scanner(new ByteArrayInputStream(input.getBytes()));

        system.createBankAccount();

        assertEquals(1, BankingManagementSystem.accounts.size());
        BankAccount account = BankingManagementSystem.accounts.get(0);

        assertTrue(account instanceof SavingsAccount);
        assertEquals("Savings", account.getAcct_type());
        assertEquals(customer.getCust_id(), account.getCust_id());
        assertEquals(1000, account.getBalance(), 0.001);
    }

    @Test
    void testSavingsAccountRejectsBalanceBelowMinimum() {
        Customer customer =
                new Customer("Carol", "carol@email.com", "5551234567");
        BankingManagementSystem.customers.add(customer);

        BankingManagementSystem.scanner =
                new Scanner(new ByteArrayInputStream(
                        (customer.getCust_id() + "\nSavings\n50\n").getBytes()
                ));

        assertThrows(InvalidAmountException.class,
                () -> system.createBankAccount());

        assertTrue(BankingManagementSystem.accounts.isEmpty());
    }

    @Test
    void testDepositAndWithdrawOperations() {
        BankAccount account =
                new SavingsAccount(1, "Savings", 500);

        account.depositMoney(200);
        assertEquals(700, account.getBalance(), 0.001);
        assertEquals(1, account.getTransactions().size());

        account.withdrawMoney(100);
        assertEquals(600, account.getBalance(), 0.001);
        assertEquals(2, account.getTransactions().size());
    }

    @Test
    void testCreateAccountWithUnknownCustomer() {
        BankingManagementSystem.scanner =
                new Scanner(new ByteArrayInputStream("999\n".getBytes()));

        assertThrows(NotFoundException.class,
                () -> system.createBankAccount());
    }

    @Test
    void testMockedAccountDeposit() {
        when(mockedAccount.getBalance()).thenReturn(500.0);

        mockedAccount.depositMoney(100);

        verify(mockedAccount).depositMoney(100);
        assertEquals(500.0, mockedAccount.getBalance(), 0.001);
    }
}
