package PaymentSystem.PaymentMethods;

// Concrete Payment Methods
public class CreditCard extends PaymentMethod {
    private String cardNumber;
    private String expiryDate;

    public CreditCard(String provider, String cardNumber, String expiryDate) {
        super(provider);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean validate() {
        // Simplified validation logic for credit cards
        return cardNumber.length() == 16 && expiryDate.matches("\\d{2}/\\d{2}");
    }
}