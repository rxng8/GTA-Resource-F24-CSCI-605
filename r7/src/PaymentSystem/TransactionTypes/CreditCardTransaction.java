package PaymentSystem.TransactionTypes;

import PaymentSystem.PaymentMethods.CreditCard;

// Credit Card Transaction
public class CreditCardTransaction extends Transaction<Long, CreditCard> {
    public CreditCardTransaction(Long id, CreditCard paymentMethod, double amount, String currency) {
        super(id, paymentMethod, amount, currency);
    }

    @Override
    public void process() {
        // Specific logic for processing credit card payments
        if (getPaymentMethod().validate()) {
            System.out.println("Processing Credit Card Transaction of " + getAmount() + " " + getCurrency());
        } else {
            System.out.println("Invalid Credit Card details.");
        }
    }
}

