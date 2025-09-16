import java.util.Random;

public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;
    
    // Default constructor
    public BankAccount() {
        this.accountHolder = "Unknown";
        this.accountNumber = 0;
        this.balance = 0.0;
    }
    
    // Constructor with name
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(900000) + 100000; // 6-digit random number
        this.balance = 0.0;
    }
    
    // Constructor with name and initial balance
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = new Random().nextInt(900000) + 100000;
        this.balance = balance;
    }
    
    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
    
    // Display account details
    public void displayAccount() {
        System.out.println("=== ACCOUNT DETAILS ===");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("=====================");
    }
    
    public static void main(String[] args) {
        // Create accounts using different constructors
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount("John Doe");
        BankAccount account3 = new BankAccount("Jane Smith", 1000.0);
        
        // Perform operations
        account2.deposit(500.0);
        account2.withdraw(200.0);
        
        account3.deposit(250.0);
        account3.withdraw(300.0);
        
        // Display all accounts
        account1.displayAccount();
        account2.displayAccount();
        account3.displayAccount();
    }
}