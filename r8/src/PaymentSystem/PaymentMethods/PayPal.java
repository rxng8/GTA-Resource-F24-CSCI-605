package PaymentSystem.PaymentMethods;

public class PayPal extends PaymentMethod {
    private String email;

    public PayPal(String provider, String email) {
        super(provider);
        this.email = email;
    }

    @Override
    public boolean validate() {
        // Simple PayPal validation
        return email.contains("@");
    }
}