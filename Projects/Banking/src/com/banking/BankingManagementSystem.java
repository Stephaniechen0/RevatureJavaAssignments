package com.banking;

import java.util.Scanner;
import java.util.ArrayList;

public class BankingManagementSystem implements BankOperations{
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Customer> customers = new ArrayList<>();
	static ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public int printMenu() {
		while (true) {
			System.out.println("====================================\r\n"
					+ "       BANKING MANAGEMENT SYSTEM\r\n"
					+ "====================================\r\n"
					+ "\r\n"
					+ "1. Create Customer\r\n"
					+ "2. Create Bank Account\r\n"
					+ "3. View Customer Details\r\n"
					+ "4. Deposit Money\r\n"
					+ "5. Withdraw Money\r\n"
					+ "6. Check Account Balance\r\n"
					+ "7. Transfer Money\r\n"
					+ "8. View Transaction History\r\n"
					+ "9. Exit\r\n"
					+ "\r\n"
					+ "Enter your choice:");
			
			int choice = 0;
			
			try {
				choice = Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.out.println("Invalid choice, choice must be a number.");
		        continue;  
			}
			
			if (choice > 0 && choice < 10) {
				return choice;
			}
			else {
				System.out.println("Invalid choice, choose a number between 1-9.");
			}
		}		
	}

	// 1	
	public void createCustomer() {
		String name = "";
		String email = "";
		String phone = "";

		System.out.println("Enter name: ");
		name = scanner.nextLine();
		System.out.println("Enter email: ");
		email = scanner.nextLine();
		System.out.println("Enter phone number: ");
		phone = scanner.nextLine();
		
		Customer a1 = new Customer(name, email, phone);
		customers.add(a1);
		System.out.println(name + " has been added with customer ID " + a1.getCust_id() + ".");
	}
	
	// 2
	public void createBankAccount() {
		int cust_id = 0;
		String accountType = "";
		
		try {
			System.out.println("Enter customer ID: ");
			cust_id = Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			System.out.println("Input must be integer, invalid customer_id.");
			return;
		}
		
		boolean found = false;
		for (Customer c : customers) {
			if (c.getCust_id() == cust_id) {
				found = true;
				break;
			}
		}
		
		if (!found) {
			System.out.println("Customer with ID " + cust_id + " not found.");
			return;
		}
		
		System.out.println("Enter account type (Current/Savings): ");
		accountType = scanner.nextLine().trim().toLowerCase();

        if (!accountType.equals("savings") && !accountType.equals("current")) {
            System.out.println("Account type must be Savings or Current.");
            return;
        }
        else if (accountType.equals("savings")) {
        	double balance;
        	try {
    			System.out.println("Enter starting balance: ");
    			balance = Double.parseDouble(scanner.nextLine().trim());
    		} catch (Exception e) {
    			System.out.println("Input must be double, invalid starting balance.");
    			return;
    		}
        	
        	if (balance < 100) {
        		System.out.println("Starting balance must be at least $100.");
        		return;
        	}
        	
        	SavingsAccount b = new SavingsAccount(cust_id, "Savings", balance);
        	accounts.add(b);
    		System.out.println("Bank account " + b.getAcct_num() + " (Savings) has been created for customer " + b.getCust_id() + ".");
        }
        else if (accountType.equals("current")) {
        	double balance;
        	try {
    			System.out.println("Enter starting balance: ");
    			balance = Double.parseDouble(scanner.nextLine().trim());
    		} catch (Exception e) {
    			System.out.println("Input must be double, invalid starting balance.");
    			return;
    		}
        	
        	if (balance < 0) {
        		System.out.println("Starting balance must be at least $0.");
        		return;
        	}
        	
        	CurrentAccount b = new CurrentAccount(cust_id, "Current", balance);
        	accounts.add(b);
    		System.out.println("Bank account " + b.getAcct_num() + " (Current) has been created for customer " + b.getCust_id() + ".");
        }
	}
	
	// 3
	public void viewCustomer() {
		int cust_id = 0;
		
		try {
			System.out.println("Enter customer ID: ");
			cust_id = Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			System.out.println("Input must be integer, invalid customer_id.");
			return;
		}
		
		boolean found = false;
		for (Customer c : customers) {
			if (c.getCust_id() == cust_id) {
				found = true;
				System.out.println(c.getCust_id() + " | " + c.getName() + " | " + c.getEmail() + " | " + c.getPhone());
				return;
			}
		}
		
		if (!found) {
			System.out.println("Customer with ID " + cust_id + " not found.");
		}
	}
	
	// 4
	public void depositMoney() {
		int acct_num = 0;
		
		try {
			System.out.println("Enter bank account number: ");
			acct_num = Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			System.out.println("Input must be integer, invalid bank account number.");
			return;
		}
		
		boolean found = false;
		for (BankAccount a : accounts) {
			if (a.getAcct_num() == acct_num) {
				found = true;
				double deposit = 0;
				
				try {
					System.out.println("Enter amount to deposit: ");
					deposit = Double.parseDouble(scanner.nextLine().trim());
				} catch (Exception e) {
					System.out.println("Input must be double, invalid amount to deposit.");
					return;
				}

				if (deposit <= 0) {
					System.out.println("Amount must be greater than 0.");
				}
				else {
					a.depositMoney(deposit);
				}
				return;
			}
		}
		
		if (!found) {
			System.out.println("Bank account with ID " + acct_num + " not found.");
		}
	}
	
	// 5
	public void withdrawMoney() {
		int acct_num = 0;
		
		try {
			System.out.println("Enter bank account number: ");
			acct_num = Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			System.out.println("Input must be integer, invalid bank account number.");
			return;
		}
		
		boolean found = false;
		for (BankAccount a : accounts) {
			if (a.getAcct_num() == acct_num) {
				found = true;
				double withdraw = 0;
				
				try {
					System.out.println("Enter amount to deposit: ");
					withdraw = Double.parseDouble(scanner.nextLine().trim());
				} catch (Exception e) {
					System.out.println("Input must be double, invalid amount to withdraw.");
					return;
				}

				if (withdraw <= 0) {
					System.out.println("Amount must be greater than 0.");
				}
				else if (a.getAcct_type() == "Current" && a.getBalance() - withdraw < 0) {
					System.out.println("Remaining balance must be greater than 0 after withdrawal.");
				}
				else if (a.getAcct_type() == "Savings" && a.getBalance() - withdraw < 100) {
					System.out.println("Remaining balance must be greater than 100 after withdrawal.");
				}
				else {
					a.withdrawMoney(withdraw);
				}
				return;
			}
		}
		
		if (!found) {
			System.out.println("Bank account with ID " + acct_num + " not found.");
		}
	}
	
	// 6
	public void checkBalance() {
		int acct_num = 0;
		
		try {
			System.out.println("Enter bank account number: ");
			acct_num = Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			System.out.println("Input must be integer, invalid bank account number.");
			return;
		}
		
		boolean found = false;
		for (BankAccount a : accounts) {
			if (a.getAcct_num() == acct_num) {
				found = true;
				System.out.println("Balance: $" + a.getBalance());
				return;
			}
		}
		
		if (!found) {
			System.out.println("Bank account with ID " + acct_num + " not found.");
		}
	}
	
	// 7
	public void fundTransfer() {
		int sender_num = 0;
		int receiver_num = 0;
		
		try {
			System.out.println("Enter sender account number: ");
			sender_num = Integer.parseInt(scanner.nextLine().trim());
			System.out.println("Enter receiver account number: ");
			receiver_num = Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			System.out.println("Input must be integer, invalid account number.");
			return;
		}
		
		if (sender_num < 0 || receiver_num < 0) {
			System.out.println("Account number invalid.");
			return;
		}
		else if (sender_num == receiver_num) {
			System.out.println("Account numbers to receive and send cannot be the same.");
			return;
		}
		
		boolean sender_found = false;
		boolean receiver_found = false;
		for (BankAccount a : accounts) {
			if (a.getAcct_num() == sender_num) {
				sender_found = true;
				
				for (BankAccount b : accounts) {
					if (b.getAcct_num() == receiver_num) {
						receiver_found = true;
						double transfer = 0;
						
						try {
							System.out.println("Enter amount to transfer: ");
							transfer = Double.parseDouble(scanner.nextLine().trim());
						} catch (Exception e) {
							System.out.println("Input must be double, invalid amount to deposit.");
							return;
						}
						
						if (transfer <= 0) {
							System.out.println("Amount must be greater than 0.");
						}
						else if (a.getAcct_type() == "Current" && a.getBalance() - transfer < 0) {
							System.out.println("Remaining balance must be greater than 0 after withdrawal.");
						}
						else if (a.getAcct_type() == "Savings" && a.getBalance() - transfer < 100) {
							System.out.println("Remaining balance must be greater than 100 after withdrawal.");
						}
						else {
							a.withdrawMoney(transfer);
							b.depositMoney(transfer);
						}
						return;
					}
				}
			}
		}
		
		if (!sender_found) {
			System.out.println("Sender account number not found");
		}
		else if (!receiver_found) {
			System.out.println("Receiver account number not found");			
		}
	}
	
	// 8
	public void transactionHistory() {
		int acct_num = 0;
		
		try {
			System.out.println("Enter bank account number: ");
			acct_num = Integer.parseInt(scanner.nextLine().trim());
		} catch (Exception e) {
			System.out.println("Input must be integer, invalid bank account number.");
			return;
		}
		
		boolean found = false;
		for (BankAccount a : accounts) {
			if (a.getAcct_num() == acct_num) {
				found = true;
				
				if (a.getTransactions().isEmpty()) {
					System.out.println("No transactions have been recorded.");
					return;
				}
				
				for (String t : a.getTransactions()) {
					System.out.println(t);
				}
				return;
			}
		}
		
		if (!found) {
			System.out.println("Bank account with ID " + acct_num + " not found.");
			return;
		}
	}
	
	public static void main(String[] args) {
		BankingManagementSystem bms = new BankingManagementSystem();
		boolean exit = false;
		while (exit != true) {
			int choice = bms.printMenu();
			switch (choice) {
				case 1:
					bms.createCustomer();
					break;
				case 2:
					bms.createBankAccount();
					break;
				case 3:
					bms.viewCustomer();
					break;
				case 4:
					bms.depositMoney();
					break;
				case 5:
					bms.withdrawMoney();
					break;
				case 6:
					bms.checkBalance();
					break;
				case 7:
					bms.fundTransfer();
					break;
				case 8:
					bms.transactionHistory();
					break;
				case 9:
					System.out.println("Exiting banking management system...");
					exit = true;
					break;
			}
			System.out.println();
		}
		System.out.println("Thank you for banking with us.");
	}

}
