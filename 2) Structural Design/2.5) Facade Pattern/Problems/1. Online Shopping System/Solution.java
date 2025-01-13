
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Customer {

    String name;
    String email;
    String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    // Add basic validation to ensure that the email is valid.
    public boolean isValid() {
        return email != null && email.contains("@");
    }
}

class Item {

    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}

class Stock {

    public static final Map<String, Integer> availability = Map.of(
            "Iphone 15 pro max", 20,
            "Dell laptop", 10
    );
}

class InventoryService {

    private List<Item> unavailableItems;

    public double calculateTotalAmount(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<Item> getUnavailableItems() {
        return unavailableItems;
    }

    // Check availability and return a list of unavailable items
    public void checkAvailability(List<Item> items) {
        unavailableItems = items.stream()
                .filter(item -> Stock.availability.getOrDefault(item.name, 0) <= 0)
                .collect(Collectors.toList());
    }
}

enum PaymentPlatform {
    GOOGLEPAY, PHONEPE, PAYTM, CREDITCARD, DEBITCARD
}

interface PaymentGateway {

    void pay(double amount);
}

class GooglePay implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " through GooglePay.");
    }
}

class DebitCard implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " through DebitCard.");
    }
}

class UnsupportedPaymentMode extends Exception {

    public UnsupportedPaymentMode(PaymentPlatform paymentPlatform) {
        super("Payment platform " + paymentPlatform + " is not supported.");
    }
}

class PaymentFactory {

    public static PaymentGateway getPaymentGateway(PaymentPlatform paymentPlatform) throws UnsupportedPaymentMode {
        switch (paymentPlatform) {
            case GOOGLEPAY:
                return new GooglePay();
            case DEBITCARD:
                return new DebitCard();
            case CREDITCARD:
                return new DebitCard(); // Replace with actual CreditCard implementation.
            default:
                throw new UnsupportedPaymentMode(paymentPlatform);
        }
    }
}

class ShippingService {

    private static final double STANDARD_CHARGE = 3;    // standard charge of 3% for each product

    public double calculateShippingCharges(List<Item> items) {
        double shippingCharge = 0;
        for (Item item : items) {
            shippingCharge += ((STANDARD_CHARGE * item.getPrice()) / 100);
        }
        return shippingCharge;
    }

    public void scheduleDelivery() {
        System.out.println("Delivery scheduled.");
    }
}

interface NotificationService {

    void notifyCustomer(Customer customer);
}

class EmailNotification implements NotificationService {

    @Override
    public void notifyCustomer(Customer customer) {
        System.out.println("Notified via Email to " + customer.getEmail());
    }
}

class SMSNotification implements NotificationService {

    @Override
    public void notifyCustomer(Customer customer) {
        System.out.println("Notified via SMS to " + customer.getPhone());  // Use phone number here in reality
    }
}

class OutOfStock extends Exception {

    public OutOfStock(List<Item> items) {
        super("Items " + items.toString() + " are out of stock.");
    }
}

class InvalidCustomerException extends Exception {

    public InvalidCustomerException() {
        super("Invalid customer details.");
    }
}

class OrderProcessingFacade {

    private InventoryService inventoryService;
    private ShippingService shippingService;
    private NotificationService notificationService;
    private PaymentPlatform paymentPlatform;

    public OrderProcessingFacade(InventoryService inventoryService, NotificationService notificationService, PaymentPlatform paymentPlatform) {
        this.inventoryService = inventoryService;
        this.shippingService = new ShippingService();
        this.notificationService = notificationService;
        this.paymentPlatform = paymentPlatform;
    }

    // Main order processing logic
    public void processOrder(Customer customer, List<Item> items) throws OutOfStock, UnsupportedPaymentMode, InvalidCustomerException {
        if (!customer.isValid()) {
            throw new InvalidCustomerException();
        }

        if (items.isEmpty()) {
            System.out.println("Expecting at least one item.");
            return;
        }

        inventoryService.checkAvailability(items);
        List<Item> unavailableItems = inventoryService.getUnavailableItems();

        if (!unavailableItems.isEmpty()) {
            throw new OutOfStock(unavailableItems);
        }

        // Calculate the total price and add shipping charges
        double totalPrice = inventoryService.calculateTotalAmount(items);
        totalPrice += shippingService.calculateShippingCharges(items);

        // Process the payment
        PaymentGateway paymentGateway = PaymentFactory.getPaymentGateway(paymentPlatform);
        paymentGateway.pay(totalPrice);

        // Schedule delivery and notify customer
        shippingService.scheduleDelivery();
        notificationService.notifyCustomer(customer);
    }
}

public class Solution {

    public static void main(String[] args) {

        List<Item> items = List.of(
                new Item("Iphone 15 pro max", 80500),
                new Item("Dell laptop", 102500)
        );

        Customer customer = new Customer("Dharmaraj", "dharma@gmail.com", "1234567890");

        // Facade with SMS Notification and CREDITCARD payment platform
        OrderProcessingFacade orderProcessingFacade = new OrderProcessingFacade(
                new InventoryService(), new SMSNotification(), PaymentPlatform.CREDITCARD
        );

        try {
            orderProcessingFacade.processOrder(customer, items);
        } catch (OutOfStock e) {
            System.err.println(e.getMessage());
        } catch (UnsupportedPaymentMode e) {
            System.err.println(e.getMessage());
        } catch (InvalidCustomerException e) {
            System.err.println(e.getMessage());
        }
    }
}
