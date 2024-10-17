package PaymentSystem.Gateway;

import PaymentSystem.PaymentMethods.PayPal;

public class EuropePaymentGateway implements PaymentGateway<PayPal> {
    @Override
    public boolean processPayment(PayPal paymentMethod, double amount, String currency) {
        // Process PayPal payments in Europe (simplified)
        System.out.println("Processing European PayPal payment for " + amount + " " + currency);
        return true; // Simplified
    }

    @Override
    public double calculateFees(PayPal paymentMethod, double amount) {
        // Flat 1.5% fee
        return amount * 0.015;
    }
}
