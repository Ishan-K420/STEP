public class SecureBankAccount {
    private final String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() {
        if (isLocked) return -1;
        return balance;
    }
    public boolean isAccountLocked() { return isLocked; }

    public void setPin(int oldPin, int newPin) {
        if (pin == oldPin) pin = newPin;
    }
    public boolean validatePin(int enteredPin) {
        if (pin == enteredPin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }
    public void unlockAccount(int correctPin) {
        if (pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
        }
    }

    public boolean deposit(double amount, int pin) {
        if (validatePin(pin) && !isLocked && amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
    public boolean withdraw(double amount, int pin) {
        if (validatePin(pin) && !isLocked && amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public boolean transfer(SecureBankAccount target, double amount, int pin) {
        if (withdraw(amount, pin)) {
            target.deposit(amount, pin);
            return true;
        }
        return false;
    }

    private void lockAccount() { isLocked = true; }
    private void resetFailedAttempts() { failedAttempts = 0; }
    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) lockAccount();
    }

    public static void main(String[] args) {
        SecureBankAccount a = new SecureBankAccount("12345", 1000);
        SecureBankAccount b = new SecureBankAccount("67890", 500);
        a.setPin(0, 1234);
        b.setPin(0, 2222);

        a.deposit(200, 1234);
        a.withdraw(50, 1234);
        b.deposit(200, 2222);
        a.transfer(b, 100, 1234);

        a.withdraw(50, 9999);
        a.withdraw(50, 8888);
        a.withdraw(50, 7777);
        System.out.println(a.isAccountLocked());
        System.out.println(a.getBalance());
    }
}
