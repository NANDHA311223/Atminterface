import java.util.Scanner;

public class BankAccount {
		    private double balance;

	    public BankAccount(double balance) {
	        this.balance = balance;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	    }

	    public boolean withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            return true;
	        }
	        return false;
	    }
	}

	class ATM {
	    private BankAccount account;

	    public ATM(BankAccount account) {
	        this.account = account;
	    }

	    public void withdraw(double amount) {
	        if (account.withdraw(amount)) {
	            System.out.println("Withdrawal successful. Remaining balance: $" + account.getBalance());
	        } else {
	            System.out.println("Insufficient balance. Withdrawal failed.");
	        }
	    }

	    public void deposit(double amount) {
	        account.deposit(amount);
	        System.out.println("Deposit successful. New balance: $" + account.getBalance());
	    }

	    public void checkBalance() {
	        System.out.println("Current balance: $" + account.getBalance());
	    }
	}

	public class Main {
	    public static void main(String[] args) {
	        BankAccount account = new BankAccount(1000.0);
	        ATM atm = new ATM(account);
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nATM Menu:");
	            System.out.println("1. Withdraw");
	            System.out.println("2. Deposit");
	            System.out.println("3. Check Balance");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter amount to withdraw: ");
	                    double withdrawAmount = scanner.nextDouble();
	                    atm.withdraw(withdrawAmount);
	                    break;
	                case 2:
	                    System.out.print("Enter amount to deposit: ");
	                    double depositAmount = scanner.nextDouble();
	                    atm.deposit(depositAmount);
	                    break;
	                case 3:
	                    atm.checkBalance();
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the ATM. Goodbye!");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	}

