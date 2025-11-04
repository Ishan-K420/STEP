class Account {
    private String accountNumber;
    private double balance;
    private String accountType;
    
    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs." + amount + ". New balance: Rs." + balance);
    }
    
    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Rs." + amount + ". Remaining balance: Rs." + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}

class Customer {
    private String customerId;
    private String name;
    private String address;
    private Account account;
    
    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }
    
    public void openAccount(Account account) {
        this.account = account;
        System.out.println(name + " opened account " + account.getAccountNumber());
    }
    
    public void viewBalance() {
        if(account != null) {
            System.out.println(name + "'s balance: Rs." + account.getBalance());
        }
    }
    
    public Account getAccount() {
        return account;
    }
    
    public String getName() {
        return name;
    }
}

class Bank {
    private String bankName;
    private String branchCode;
    private Customer[] customers;
    private int customerCount;
    
    public Bank(String bankName, String branchCode) {
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.customers = new Customer[100];
        this.customerCount = 0;
    }
    
    public void addCustomer(Customer customer) {
        customers[customerCount++] = customer;
        System.out.println(bankName + " added customer: " + customer.getName());
    }
    
    public void displayAllCustomers() {
        System.out.println("Customers of " + bankName + ":");
        for(int i = 0; i < customerCount; i++) {
            System.out.println("  - " + customers[i].getName());
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI", "BR001");
        
        Customer cust1 = new Customer("C001", "Ravi Kumar", "Chennai");
        Customer cust2 = new Customer("C002", "Priya Sharma", "Mumbai");
        
        Account acc1 = new Account("ACC12345", 5000, "Savings");
        Account acc2 = new Account("ACC67890", 10000, "Current");
        
        cust1.openAccount(acc1);
        cust2.openAccount(acc2);
        
        bank.addCustomer(cust1);
        bank.addCustomer(cust2);
        
        cust1.viewBalance();
        acc1.deposit(2000);
        acc1.withdraw(1500);
    }
}
