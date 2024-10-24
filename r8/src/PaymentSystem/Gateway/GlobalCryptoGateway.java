package PaymentSystem.Gateway;


import PaymentSystem.PaymentMethods.CryptoCurrency;

public class GlobalCryptoGateway implements PaymentGateway<CryptoCurrency> {
    @Override
    public boolean processPayment(CryptoCurrency paymentMethod, double amount, String currency) {
        // Process cryptocurrency payments worldwide (simplified)
        System.out.println("Processing Global Crypto payment for " + amount + " " + currency);
        return true; // Simplified
    }

    @Override
    public double calculateFees(CryptoCurrency paymentMethod, double amount) {
        // No fee for crypto
        return 0;
    }
}