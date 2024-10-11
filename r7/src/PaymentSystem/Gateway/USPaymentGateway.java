package PaymentSystem.Gateway;

import PaymentSystem.PaymentMethods.CreditCard;

// Concrete implementation for region-specific gateways
public class USPaymentGateway implements PaymentGateway<CreditCard> {
    @Override
    public boolean processPayment(CreditCard paymentMethod, double amount, String currency) {
        // Process US-based credit card payments (simplified)
        System.out.println("Processing US Credit Card payment for " + amount + " " + currency);
        return true; // Simplified
    }

    @Override
    public double calculateFees(CreditCard paymentMethod, double amount) {
        // Flat 2% fee
        return amount * 0.02;
    }
}
