public class BankAccount {
    private double balance; // encapsulated field

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    // Overload 1
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);
    }

    // Overload 2 (compile-time polymorphism)
    public void deposit(double amount, String remarks) {
        balance += amount;
        System.out.println("Deposited: " + amount + " (Remarks: " + remarks + ") | Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(0.0);
        account.deposit(5000.0);
        account.deposit(2000.0, "Salary");
        System.out.println("Final Balance: " + account.getBalance());
    }
}
