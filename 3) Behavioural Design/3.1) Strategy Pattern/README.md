### **Strategy Design Pattern:**

#### **Definition:**

The **Strategy Design Pattern** is a behavioral design pattern that allows you to **define a family of algorithms** (strategies), encapsulate each one, and make them interchangeable. The strategy pattern lets the algorithm vary independently from the clients that use it.

The pattern involves:

1. A **Strategy** interface that defines a method signature for an algorithm.
2. **ConcreteStrategy** classes that implement the Strategy interface and provide specific algorithm implementations.
3. A **Context** class that maintains a reference to a Strategy object and delegates the execution of the algorithm to the strategy.

---

#### **When and Why to Use the Strategy Pattern:**

**When to Use:**

1. **When you have multiple related algorithms** and need to switch between them at runtime without changing the context class.
2. **When you want to avoid using conditionals** (e.g., if-else or switch-case statements) for algorithm selection in your code, which makes the code cleaner and more maintainable.
3. **When you want to enable easy extension** of the system, allowing new algorithms (strategies) to be added without modifying the existing code (open-closed principle).
4. **When algorithms can vary independently** from the context in which they are used. This separation of concerns allows for greater flexibility and encapsulation.

**Why to Use:**

1. **Decoupling algorithm selection from implementation**: The strategy pattern separates the concerns of choosing an algorithm and implementing it, allowing you to add new strategies without modifying the existing code.
2. **Flexibility**: It allows the client to change its behavior dynamically by selecting the appropriate algorithm at runtime.
3. **Elimination of conditional statements**: Instead of using long if-else chains or switch-case statements, you can encapsulate these conditions in separate strategy classes, making the code cleaner.
4. **Easy to add new algorithms**: When a new algorithm is required, you can create a new strategy class without changing the context or other strategy classes.

---

#### **Before Using the Strategy Pattern:**

**Problem Scenario:**

- You have a class with several methods performing a similar task but with different algorithms (e.g., multiple sorting algorithms, different payment methods, etc.).
- The algorithm selection logic is embedded within the context class, often using complex if-else or switch statements to choose the appropriate algorithm.
- If you need to add a new algorithm or modify an existing one, it often requires changes to the context class, violating the **open-closed principle**.
- The code is becoming difficult to maintain as more algorithms are added, and it is hard to modify or extend the functionality.

**Example (Before):**

```java
public class PaymentProcessor {

    public String processPayment(double amount, String paymentMethod) {
        if (paymentMethod.equals("CreditCard")) {
            // Credit Card payment processing logic
            return "Credit Card Payment";
        } else if (paymentMethod.equals("PayPal")) {
            // PayPal payment processing logic
            return "PayPal Payment";
        } else if (paymentMethod.equals("Bitcoin")) {
            // Bitcoin payment processing logic
            return "Bitcoin Payment";
        }
        return "Unknown Payment Method";
    }
}
```

Here, we have **conditionals** deciding which algorithm (payment method) to use, making the system less flexible and harder to extend.

---

#### **After Using the Strategy Pattern:**

**Solution Scenario:**

- The selection of the algorithm (strategy) is now handled separately, using a family of algorithms encapsulated in strategy classes.
- The context class is simplified as it delegates the responsibility of executing the algorithm to the strategy class, making the context class unaware of the specific algorithms.
- New strategies (payment methods, sorting algorithms, etc.) can be added without changing the context class, preserving the **open-closed principle**.

**Example (After):**

```java
// Strategy Interface
public interface PaymentStrategy {
    String processPayment(double amount);
}

// Concrete Strategies
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public String processPayment(double amount) {
        return "Processing Credit Card Payment of $" + amount;
    }
}

public class PayPalPayment implements PaymentStrategy {
    @Override
    public String processPayment(double amount) {
        return "Processing PayPal Payment of $" + amount;
    }
}

public class BitcoinPayment implements PaymentStrategy {
    @Override
    public String processPayment(double amount) {
        return "Processing Bitcoin Payment of $" + amount;
    }
}

// Context Class
public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public String processPayment(double amount) {
        return paymentStrategy.processPayment(amount);
    }
}

// Client Code
public class Solution {
    public static void main(String[] args) {
        PaymentStrategy strategy = new PayPalPayment();  // Can easily change strategy
        PaymentProcessor processor = new PaymentProcessor(strategy);
        System.out.println(processor.processPayment(100.0));
    }
}
```

**In this case:**

- The **context (`PaymentProcessor`)** simply delegates the task to the **strategy (`PaymentStrategy`)** without worrying about the algorithm.
- The **strategies** (`CreditCardPayment`, `PayPalPayment`, etc.) are independent and interchangeable.
- If a new payment method (strategy) needs to be added, just create a new concrete strategy class and inject it into the `PaymentProcessor`—no need to modify existing code.

---

### **Summary of Before and After:**

**Before Using Strategy Pattern:**

- **Conditionals** (if-else or switch) determine the algorithm to use.
- The context class contains the logic for choosing and executing the algorithm.
- Harder to maintain and extend, as each new algorithm requires modifying the context class.

**After Using Strategy Pattern:**

- Algorithms (strategies) are encapsulated in separate classes.
- The context class delegates the algorithm selection to the chosen strategy.
- Easier to maintain and extend by adding new strategies without modifying existing code.

---

### **Conclusion:**

The **Strategy Design Pattern** is a powerful tool to decouple algorithm selection from its implementation. It makes the system more flexible, extensible, and easier to maintain by encapsulating each algorithm and allowing them to be easily swapped at runtime.
