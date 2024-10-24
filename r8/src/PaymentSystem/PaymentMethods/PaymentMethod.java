package PaymentSystem.PaymentMethods;

// Base class for different payment methods
public abstract class PaymentMethod {
    private String provider;

    public PaymentMethod(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }

    public abstract boolean validate();  // Each payment method has its own validation rules
}

