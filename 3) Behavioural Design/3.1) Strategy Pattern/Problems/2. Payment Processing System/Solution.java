
import java.util.Map;

abstract class PaymentStrategy {

    protected String getMessage(String paymentMode, double amount, double PLATFORM_FEE_PERCENTAGE) {
        return "Processing " + paymentMode + " payment. Amount after " + PLATFORM_FEE_PERCENTAGE + "% fee: $" + amount;
    }

    protected double deductPlatformFeeFromAmount(double amount, double PLATFORM_FEE_PERCENTAGE) {
        double platformFee = (amount * PLATFORM_FEE_PERCENTAGE) / 100;
        return amount - platformFee;
    }

    public abstract String processPayment(double amount);
}

enum PaymentMethod {

    CREDIT_CARD, PAYPAL, BITCOIN, APPLE_PAY
}

class CreditCardPayment extends PaymentStrategy {

    private static final double PLATFORM_FEE_PERCENTAGE = 2;    // in percentage

    @Override
    public String processPayment(double amount) {
        amount = deductPlatformFeeFromAmount(amount, PLATFORM_FEE_PERCENTAGE);
        return getMessage("Credit Card", amount, PLATFORM_FEE_PERCENTAGE);
    }
}

class PayPalPayment extends PaymentStrategy {

    private static final double PLATFORM_FEE_PERCENTAGE = 3;    // in percentage

    @Override
    public String processPayment(double amount) {
        amount = deductPlatformFeeFromAmount(amount, PLATFORM_FEE_PERCENTAGE);
        return getMessage("PayPal", amount, PLATFORM_FEE_PERCENTAGE);
    }
}

class BitcoinPayment extends PaymentStrategy {

    private static final double PLATFORM_FEE_PERCENTAGE = 1.3;    // in percentage

    @Override
    public String processPayment(double amount) {
        amount = deductPlatformFeeFromAmount(amount, PLATFORM_FEE_PERCENTAGE);
        return getMessage("Bitcoin", amount, PLATFORM_FEE_PERCENTAGE);
    }
}

class ApplePayPayment extends PaymentStrategy {

    private static final double PLATFORM_FEE_PERCENTAGE = 0;    // in percentage

    @Override
    public String processPayment(double amount) {
        amount = deductPlatformFeeFromAmount(amount, PLATFORM_FEE_PERCENTAGE);
        return getMessage("Apple Pay", amount, PLATFORM_FEE_PERCENTAGE);
    }
}

class PaymentFactory {

    private static Map<PaymentMethod, PaymentStrategy> registry = Map.of(
            PaymentMethod.CREDIT_CARD, new CreditCardPayment(),
            PaymentMethod.PAYPAL, new PayPalPayment(),
            PaymentMethod.BITCOIN, new BitcoinPayment(),
            PaymentMethod.APPLE_PAY, new ApplePayPayment()
    );

    public static PaymentStrategy getStrategy(PaymentMethod paymentMethod) {
        return registry.getOrDefault(paymentMethod, new CreditCardPayment());
    }
}

class PaymentProcessor {

    PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        if (paymentStrategy == null) {
            throw new IllegalArgumentException("PaymentStrategy cannot be null");
        }
        this.paymentStrategy = paymentStrategy;
    }

    public String processPayment(double amount) {
        return paymentStrategy.processPayment(amount);
    }
}

public class Solution {

    public static void main(String[] args) {

        double amount = 13457;
        PaymentMethod paymentMethod = PaymentMethod.PAYPAL;

        PaymentStrategy paymentStrategy = PaymentFactory.getStrategy(paymentMethod);

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentStrategy);
        String message = paymentProcessor.processPayment(amount);
        System.out.println(message);
    }
}
