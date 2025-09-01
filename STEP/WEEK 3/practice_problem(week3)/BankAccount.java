package week3.practice_problems;

public class BankAccount {
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    // Static Methods
    public static void setBankName(String name) { bankName = name; }
    public static void setInterestRate(double rate) { interestRate = rate; }
    public static int getTotalAccounts() { return totalAccounts; }
    public static void displayBankInfo() {
        System.out.println("Bank: " + bankName + " | Total Accounts: " + totalAccounts + " | Rate: " + interestRate);
    }

    // Instance Methods
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }
    public double calculateInterest() { return balance * interestRate / 100; }
    public void displayAccountInfo() {
        System.out.println("Account " + accountNumber + " | Holder: " + accountHolder + " | Balance: " + balance);
    }

    public static void main(String[] args) {
        setBankName("CodeBank");
        setInterestRate(5.0);

        BankAccount acc1 = new BankAccount("A001", "Sanyam", 1000);
        BankAccount acc2 = new BankAccount("A002", "Isha", 2000);

        acc1.deposit(500);
        acc2.withdraw(300);

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        displayBankInfo();
    }
}
