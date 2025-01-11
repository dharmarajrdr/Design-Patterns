### **Problem Statement: Payment Processing System**

You are developing a **payment processing system** for an e-commerce platform. The platform needs to support various payment methods such as **Credit Card**, **PayPal**, **Bitcoin**, and **Apple Pay**. Each payment method has its own set of rules, fees, and processes for transaction approval.

Design a flexible system where different payment strategies can be applied depending on the user's choice. The system should allow users to select their preferred payment method, and the transaction should be processed accordingly using the selected strategy.

---

### **Classes:**

- **PaymentStrategy** (interface): Defines a method for processing payments.
  - Method: `processPayment(amount: double) : String`
- **CreditCardPayment**, **PayPalPayment**, **BitcoinPayment**, **ApplePayPayment** (concrete strategies): Implement the `PaymentStrategy` interface.
- **PaymentProcessor**: Context class that uses a `PaymentStrategy` to process payments.

---

### **Requirements:**

1. Each payment method (Credit Card, PayPal, Bitcoin, Apple Pay) should be represented as a different strategy.
2. The system should be able to switch between payment methods easily, based on the user's selection.
3. Each payment method has different fee structures and processing rules:
   - Credit Card: 2% fee on the total amount.
   - PayPal: 3% fee on the total amount.
   - Bitcoin: 1% fee on the total amount.
   - Apple Pay: 0% fee on the total amount.
4. The `PaymentProcessor` class should delegate the payment process to the chosen strategy.
5. The design should be flexible enough to allow for adding new payment methods in the future.

---

### **Sample Input 1:**

```java
PaymentProcessor processor = new PaymentProcessor();

// User selects Credit Card for payment
PaymentStrategy creditCard = new CreditCardPayment();
processor.setPaymentStrategy(creditCard);

// Process payment of $100
String result = processor.processPayment(100.0);
```

### **Expected Output 1:**

```
Processing Credit Card payment. Amount after 2% fee: $98.0
```

---

### **Sample Input 2:**

```java
PaymentProcessor processor = new PaymentProcessor();

// User selects PayPal for payment
PaymentStrategy paypal = new PayPalPayment();
processor.setPaymentStrategy(paypal);

// Process payment of $200
String result = processor.processPayment(200.0);
```

### **Expected Output 2:**

```
Processing PayPal payment. Amount after 3% fee: $194.0
```

---

### **Sample Input 3:**

```java
PaymentProcessor processor = new PaymentProcessor();

// User selects Bitcoin for payment
PaymentStrategy bitcoin = new BitcoinPayment();
processor.setPaymentStrategy(bitcoin);

// Process payment of $500
String result = processor.processPayment(500.0);
```

### **Expected Output 3:**

```
Processing Bitcoin payment. Amount after 1% fee: $495.0
```

---

### **Sample Input 4:**

```java
PaymentProcessor processor = new PaymentProcessor();

// User selects Apple Pay for payment
PaymentStrategy applePay = new ApplePayPayment();
processor.setPaymentStrategy(applePay);

// Process payment of $300
String result = processor.processPayment(300.0);
```

### **Expected Output 4:**

```
Processing Apple Pay payment. Amount after 0% fee: $300.0
```

---

### **Notes:**

- The `PaymentProcessor` should calculate the fee based on the strategy and display the resulting amount after the fee is applied.
- The fee percentages mentioned are examples and can be customized for each payment method.
