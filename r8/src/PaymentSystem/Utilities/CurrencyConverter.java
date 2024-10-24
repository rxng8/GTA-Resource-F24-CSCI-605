package PaymentSystem.Utilities;

// Utility class for converting between currencies
public class CurrencyConverter {
    public static double convert(double amount, String fromCurrency, String toCurrency) {
        // Simplified conversion logic
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return amount * 0.85;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return amount * 1.18;
        }
        // Add more conversions as needed
        return amount;
    }
}

