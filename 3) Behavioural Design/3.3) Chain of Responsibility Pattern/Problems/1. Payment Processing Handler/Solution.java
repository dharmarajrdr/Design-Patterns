abstract class PaymentHandler {

    protected PaymentHandler next;

    public void setNext(PaymentHandler next) {
        this.next = next;
    }

    public void handlePayment(double amount) {

        throw new RuntimeException("No handlings implemented for this amount.");
    }
}

class CreditCardPaymentHandler extends PaymentHandler {

    @Override
    public void handlePayment(double amount) {
        
        if(amount < 1000) {
            System.out.println("Amount " + amount + " has been transferred via credit card.");
        } else {
            next.handlePayment(amount);
        }
    }

}

class PayPalPaymentHandler extends PaymentHandler {

    @Override
    public void handlePayment(double amount) {
        
        if(amount < 12500) {
            System.out.println("Amount " + amount + " has been transferred via PayPal.");
        } else {
            next.handlePayment(amount);
        }
    }

}

class BankPaymentHandler extends PaymentHandler {

    @Override
    public void handlePayment(double amount) {
        
        System.out.println("Amount " + amount + " has been transferred via bank transfer.");
    }

}

public class Solution {

    public static void main(String[] args) {
        
        PaymentHandler credit = new CreditCardPaymentHandler();
        PaymentHandler paypal = new PayPalPaymentHandler();
        PaymentHandler bank = new BankPaymentHandler();

        credit.setNext(paypal);
        paypal.setNext(bank);

        credit.handlePayment(500);      // Handled by CreditCardPaymentHandler
        credit.handlePayment(12000);    // Handled by PayPalPaymentHandler
        credit.handlePayment(80000);    // Handled by BankPaymentHandler
    }
}