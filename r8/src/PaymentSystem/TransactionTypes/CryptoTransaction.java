package PaymentSystem.TransactionTypes;


import PaymentSystem.PaymentMethods.CryptoCurrency;

// CryptoCurrency Transaction
public class CryptoTransaction extends Transaction<String, CryptoCurrency> {
    public CryptoTransaction(String id, CryptoCurrency paymentMethod, double amount, String currency) {
        super(id, paymentMethod, amount, currency);
    }

    @Override
    public void process() {
        // Specific logic for processing cryptocurrency payments
        if (getPaymentMethod().validate()) {
            System.out.println("Processing CryptoCurrency Transaction of " + getAmount() + " " + getCurrency());
        } else {
            System.out.println("Invalid Crypto wallet address.");
        }
    }
}