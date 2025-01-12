
interface PaymentGateway {

    void processPayment(String account, double amount);
}

class PhonePePaymentService implements PaymentGateway {

    @Override
    public void processPayment(String account, double amount) {
        System.out.println("Processing payment of ₹" + amount + " for account: " + account + " using PhonePe.");
    }
}

class GooglePayService {

    public void payToUser(String gpayId, double totalAmount) {
        System.out.println("Payment of ₹" + totalAmount + " completed for Google Pay ID: " + gpayId + ".");
    }
}

class GooglePayAdapter implements PaymentGateway {

    GooglePayService googlePayService;

    public GooglePayAdapter(GooglePayService googlePayService) {
        this.googlePayService = googlePayService;
    }

    @Override
    public void processPayment(String account, double amount) {
        this.googlePayService.payToUser(account, amount);
    }

}

class InvalidPaymentServiceException extends RuntimeException {

    public InvalidPaymentServiceException(String message) {
        super(message);
    }
}

class PaymentGatewayFactory {

    public static PaymentGateway getPaymentGateway(String service) {
        switch (service) {
            case "GooglePay":
                return new GooglePayAdapter(new GooglePayService());
            case "PhonePe":
                return new PhonePePaymentService();
            default:
                throw new InvalidPaymentServiceException("Invalid service: " + service);
        }
    }
}

public class Solution {

    private static void pay(String account, double amount, String service) throws InvalidPaymentServiceException {
        PaymentGateway paymentGateway = PaymentGatewayFactory.getPaymentGateway(service);
        paymentGateway.processPayment(account, amount);
    }

    public static void main(String[] args) {

        pay("phonepe_user123", 500.00, "PhonePe");
        pay("gpay_user456", 1200.50, "GooglePay");
    }
}
