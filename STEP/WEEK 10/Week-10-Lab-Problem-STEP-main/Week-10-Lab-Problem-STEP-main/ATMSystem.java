class ATM {
    double balance;
    
    ATM(double initialBalance) {
        this.balance = initialBalance;
    }
    
    void withdrawMoney(double amount) {
        if(amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
            System.out.println("Remaining balance: Rs." + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
    void checkBalance() {
        System.out.println("Current balance: Rs." + balance);
    }
    
    void depositMoney(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs." + amount);
        System.out.println("New balance: Rs." + balance);
    }
}

class User {
    String name;
    String accountNumber;
    
    User(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }
    
    void useATM(ATM atm) {
        System.out.println(name + " is using ATM");
        atm.checkBalance();
        atm.depositMoney(5000);
        atm.withdrawMoney(2000);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        ATM atm = new ATM(10000);
        User user = new User("Vikram", "ACC12345");
        
        user.useATM(atm);
    }
}
