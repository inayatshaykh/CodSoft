import java.util.Scanner;

public class ATM {
    
    // Nested class to represent the user's bank account
    private static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful. New balance is: $" + String.format("%.2f", balance));
            } else {
                System.out.println("Invalid deposit amount. Please enter a positive value.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount. Please enter a positive value.");
                return false;
            } else if (amount > balance) {
                System.out.println("Insufficient funds. Withdrawal failed.");
                return false;
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance is: $" + String.format("%.2f", balance));
                return true;
            }
        }
    }

    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            processChoice(choice);
        } while (choice != 4);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n*** Welcome to the ATM ***");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Please select an option: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number from 1 to 4.");
            scanner.next();
            displayMenu();
        }
        return scanner.nextInt();
    }

    private void processChoice(int choice) {
        double amount;
        switch (choice) {
            case 1:
                System.out.println("Your current balance is: $" + String.format("%.2f", userAccount.getBalance()));
                break;
            case 2:
                System.out.print("Enter amount to deposit: $");
                amount = scanner.nextDouble();
                userAccount.deposit(amount);
                break;
            case 3:
                System.out.print("Enter amount to withdraw: $");
                amount = scanner.nextDouble();
                userAccount.withdraw(amount);
                break;
            case 4:
                System.out.println("Thank you for using our ATM. Goodbye!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void main(String[] args) {
        // We now create the BankAccount instance directly within the main method
        BankAccount account = new BankAccount(1000.00); 
        ATM atm = new ATM(account);
        atm.start();
    }
}