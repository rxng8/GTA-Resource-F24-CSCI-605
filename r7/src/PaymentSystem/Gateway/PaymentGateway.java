package PaymentSystem.Gateway;

import PaymentSystem.PaymentMethods.PaymentMethod;

// Interface for different payment gateways
public interface PaymentGateway<T extends PaymentMethod> {
    boolean processPayment(T paymentMethod, double amount, String currency);
    double calculateFees(T paymentMethod, double amount);
}
