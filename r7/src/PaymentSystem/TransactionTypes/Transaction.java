package PaymentSystem.TransactionTypes;


import PaymentSystem.PaymentMethods.PaymentMethod;

// Abstract base class for any transaction with a generic payment method and identifier
public abstract class Transaction<ID, P extends PaymentMethod> {
    private ID id;
    private P paymentMethod;
    private double amount;
    private String currency;

    public Transaction(ID id, P paymentMethod, double amount, String currency) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.currency = currency;
    }

    public ID getId() {
        return id;
    }

    public P getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public abstract void process(); // Define processing behavior in concrete implementations
}

