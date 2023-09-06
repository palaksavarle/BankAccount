package com.first;
import java.util.Scanner;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void showOptions() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void operate() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showOptions();
            System.out.print("Enter option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Current balance: $" + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Have a nice day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

 
