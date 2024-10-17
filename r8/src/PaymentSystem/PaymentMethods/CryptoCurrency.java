package PaymentSystem.PaymentMethods;

public class CryptoCurrency extends PaymentMethod {
    private String walletAddress;

    public CryptoCurrency(String provider, String walletAddress) {
        super(provider);
        this.walletAddress = walletAddress;
    }

    @Override
    public boolean validate() {
        // Simple validation for cryptocurrency wallets
        return walletAddress.length() >= 30;
    }
}