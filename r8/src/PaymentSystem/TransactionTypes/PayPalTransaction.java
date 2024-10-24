package PaymentSystem.TransactionTypes;


import PaymentSystem.PaymentMethods.PayPal;

// PayPal Transaction
public class PayPalTransaction extends Transaction<Long, PayPal> {
    public PayPalTransaction(Long id, PayPal paymentMethod, double amount, String currency) {
        super(id, paymentMethod, amount, currency);
    }

    @Override
    public void process() {
        // Specific logic for processing PayPal payments
        if (getPaymentMethod().validate()) {
            System.out.println("Processing PayPal Transaction of " + getAmount() + " " + getCurrency());
        } else {
            System.out.println("Invalid PayPal details.");
        }
    }
}