### **Problem Statement: Integrating a New Payment Service**

Your **e-commerce platform** currently uses **PhonePe** to process payments via the following interface:

```java
interface PaymentGateway {
    void processPayment(String account, double amount);
}
```

The platform has an existing implementation for **PhonePe**:

```java
class PhonePePaymentService implements PaymentGateway {
    @Override
    public void processPayment(String account, double amount) {
        System.out.println("Processing payment of ₹" + amount + " for account: " + account + " using PhonePe.");
    }
}
```

Now, the business wants to integrate **Google Pay** as an additional payment option. However, **Google Pay** uses a different interface:

```java
class GooglePayService {
    public void payToUser(String gpayId, double totalAmount) {
        System.out.println("Payment of ₹" + totalAmount + " completed for Google Pay ID: " + gpayId + ".");
    }
}
```

---

### **Requirement**

1. Use the **Adapter Design Pattern** to make **Google Pay** compatible with the `PaymentGateway` interface.
2. Ensure the `PaymentGateway` interface remains unchanged to avoid affecting existing `PhonePe` implementations.
3. Allow the system to handle payments through **both PhonePe and Google Pay**.

---

### **Sample Input and Output**

1. **Using PhonePe**:

   ```java
   paymentGateway.processPayment("phonepe_user123", 500.00);
   ```

   **Output**:  
   `Processing payment of ₹500.0 for account: phonepe_user123 using PhonePe.`

2. **Using Google Pay through Adapter**:
   ```java
   paymentGateway.processPayment("gpay_user456", 1200.50);
   ```
   **Output**:  
   `Payment of ₹1200.5 completed for Google Pay ID: gpay_user456.`

---

### **Your Task**

1. Implement the adapter to bridge **Google Pay** with the `PaymentGateway` interface.
2. Ensure seamless integration for both payment services.
