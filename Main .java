import java.util.Scanner;

// BankAccount class represents the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}

// ATM class represents the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw.");
        System.out.println("2. Deposit. ");
        System.out.println("3. Check Balance. ");
        System.out.println("4. Exit. ");
    }

    public void executeOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > 0) {
                    account.withdraw(withdrawAmount);
                } else {
                    System.out.println("Invalid amount.");
                }
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    account.deposit(depositAmount);
                } else {
                    System.out.println("Invalid amount.");
                }
                break;
            case 3:
                System.out.println("Current balance: " + account.getBalance());
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
 class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Example initial balance
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the ATM...select an option:");
            atm.displayOptions();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.executeOption(choice);
        }
    }
}