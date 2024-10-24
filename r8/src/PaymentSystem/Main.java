package PaymentSystem;

import PaymentSystem.Gateway.EuropePaymentGateway;
import PaymentSystem.Gateway.GlobalCryptoGateway;
import PaymentSystem.Gateway.PaymentGateway;
import PaymentSystem.Gateway.USPaymentGateway;
import PaymentSystem.PaymentMethods.CreditCard;
import PaymentSystem.PaymentMethods.CryptoCurrency;
import PaymentSystem.PaymentMethods.PayPal;
import PaymentSystem.Services.PaymentService;
import PaymentSystem.TransactionTypes.CreditCardTransaction;
import PaymentSystem.TransactionTypes.CryptoTransaction;
import PaymentSystem.TransactionTypes.PayPalTransaction;

/**
 *
 * We need to create a generic payment system that supports:
 * 1. **Different Payment Methods**: Such as `CreditCard`, `PayPal`, and `CryptoCurrency`.
 * 2. **Region-based Configurations**: Each payment method can have specific rules, fees,
 *  and gateways for different regions.
 * 3. **Currency Conversion**: The system should handle transactions in multiple currencies
 *  with conversion support.
 * 4. **Generic Payment Processing**: It should handle payment transactions generically but
 *  with specific rules for each payment method.
 *
 *
 *
 * KEY CONCEPTS:
 * 1. **Generics for Payment Methods and Transactions**:
 * - The `PaymentService`, `Transaction`, and `PaymentGateway` are all generic,
 *  allowing them to handle different types of payment methods and transaction identifiers.
 *
 * 2. **Region-Specific Gateways**:
 * - We define different payment gateways (`USPaymentGateway`, `EuropePaymentGateway`,
 *  `GlobalCryptoGateway`) to handle region-specific rules and fees.
 *
 * 3. **Currency Conversion**:
 * - The `CurrencyConverter` handles converting amounts between currencies, making the
 *  system adaptable to global transactions.
 *
 * 4. **Transaction Processing**:
 * - Each payment method (`CreditCard`, `PayPal`, `CryptoCurrency`) has its own specific
 *  validation logic and processing rules, handled in a generic and reusable way using generics.
 *
 *
 */


public class Main {
    public static void main(String[] args) {
        // Credit Card in the US
        PaymentGateway<CreditCard> usGateway = new USPaymentGateway();
        PaymentService<CreditCard, Long> usPaymentService = new PaymentService<>(usGateway);
        CreditCardTransaction creditCardTransaction = new CreditCardTransaction(1L, new CreditCard("Visa", "1234567812345678", "12/23"), 100, "USD");
        usPaymentService.processTransaction(creditCardTransaction);

        // PayPal in Europe
        PaymentGateway<PayPal> euGateway = new EuropePaymentGateway();
        PaymentService<PayPal, Long> euPaymentService = new PaymentService<>(euGateway);
        PayPalTransaction payPalTransaction = new PayPalTransaction(2L, new PayPal("PayPal", "user@example.com"), 150, "EUR");
        euPaymentService.processTransaction(payPalTransaction);

        // Cryptocurrency globally
        PaymentGateway<CryptoCurrency> globalCryptoGateway = new GlobalCryptoGateway();
        PaymentService<CryptoCurrency, String> cryptoPaymentService = new PaymentService<>(globalCryptoGateway);
        CryptoTransaction cryptoTransaction = new CryptoTransaction("tx123", new CryptoCurrency("Bitcoin", "abc123xyz456"), 0.005, "BTC");
        cryptoPaymentService.processTransaction(cryptoTransaction);
    }
}

