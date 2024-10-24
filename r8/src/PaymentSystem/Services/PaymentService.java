package PaymentSystem.Services;

import PaymentSystem.Gateway.PaymentGateway;
import PaymentSystem.PaymentMethods.PaymentMethod;
import PaymentSystem.TransactionTypes.Transaction;
import PaymentSystem.Utilities.CurrencyConverter;

// Generic payment service
public class PaymentService<T extends PaymentMethod, ID> {
    private PaymentGateway<T> gateway;

    public PaymentService(PaymentGateway<T> gateway) {
        this.gateway = gateway;
    }

    public void processTransaction(Transaction<ID, T> transaction) {
        // Convert currency if necessary
        double amount = CurrencyConverter.convert(transaction.getAmount(), transaction.getCurrency(), "USD");
        double fees = gateway.calculateFees(transaction.getPaymentMethod(), amount);

        System.out.println("Converted amount: " + amount);
        System.out.println("Calculated fees: " + fees);

        // Process payment
        if (gateway.processPayment(transaction.getPaymentMethod(), amount, transaction.getCurrency())) {
            transaction.process(); // Each transaction processes differently
        } else {
            System.out.println("Payment processing failed.");
        }
    }
}