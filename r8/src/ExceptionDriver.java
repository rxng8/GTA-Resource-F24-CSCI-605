// Custom checked exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Custom unchecked exception (runtime exception)
class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot deposit a negative amount!");  // Unchecked exception
        }
        balance += amount;
        System.out.println("Successfully deposited: " + amount + ". Current balance: " + balance);
    }

    // Method to withdraw money - throws checked exception
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot withdraw a negative amount!");  // Unchecked exception
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! You have only " + balance + " in your account.");
        }

        balance -= amount;
        System.out.println("Successfully withdrew: " + amount + ". Current balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class ExceptionDriver {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);  // Initial balance $1000

        try {
            // Deposit operation
            account.deposit(500);  // Success
            account.deposit(-100); // This will throw an unchecked exception

        } catch (NegativeAmountException e) {
            System.out.println("Exception caught: " + e.getMessage());  // Handle unchecked exception

        } finally {
            System.out.println("Deposit operation completed.");
        }

        try {
            // Withdraw operation with sufficient balance
            account.withdraw(300);  // Success

            // Withdraw operation with insufficient balance
            account.withdraw(2000);  // This will throw a checked exception

        } catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());  // Handle checked exception

        } finally {
            System.out.println("Withdraw operation completed.");
        }

        try {
            // Withdraw a negative amount (this will throw an unchecked exception)
            account.withdraw(-100);

        } catch (NegativeAmountException e) {
            System.out.println("Exception caught: " + e.getMessage());

        } catch (InsufficientFundsException e) {
            System.out.println("This will never be reached as the negative amount will throw an unchecked exception first.");

        } finally {
            System.out.println("Negative withdrawal check completed.");
        }

        // Checking balance after all operations
        System.out.println("Final balance: " + account.getBalance());
    }
}