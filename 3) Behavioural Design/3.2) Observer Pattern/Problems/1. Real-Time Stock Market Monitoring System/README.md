### **Problem Statement: Real-Time Stock Market Monitoring System**

You are tasked with designing a real-time stock market monitoring system where multiple users (observers) want to receive live updates of stock prices. The stock market (subject) changes frequently, and users are interested in receiving notifications when certain stock prices change. The users may have different preferences, such as receiving notifications for price increases, decreases, or price alerts when a stock hits a specific target value.

#### **Requirements:**

1. **Stock Market** (Subject):

   - The stock market holds a list of stocks and their current prices.
   - The stock market allows users to register as observers, and whenever the stock prices change, all registered observers should be notified with the updated price.
   - The stock market should provide a method to update the price of a specific stock.

2. **User** (Observer):

   - A user can register for updates on one or more stocks.
   - The user should be able to specify which stocks they are interested in, and whether they want to receive updates for price increases, decreases, or specific price targets (e.g., “notify me when Stock X hits $100”).
   - A user can also unsubscribe from stock price updates when they no longer wish to receive notifications.

3. **StockPriceNotification**:
   - When a stock's price changes, the system should notify all registered users who have shown interest in that stock.
   - Different users may have different notification preferences:
     - Some users may only want notifications when the price increases.
     - Some users may only want notifications when the price decreases.
     - Some users may want to be notified when the price hits a specific threshold.
4. **Dynamic Subscription and Unsubscription**:

   - Users can dynamically subscribe or unsubscribe to updates on specific stocks at any time.

5. **Performance Consideration**:
   - The system should be efficient and able to handle a large number of users and stock updates, ensuring that notifications are delivered promptly and without delay.

#### **Example:**

1. **Stock Data:**

   - Stock A: $120
   - Stock B: $50

2. **Users and Preferences:**

   - **User 1**: Interested in Stock A, wants to be notified for price increases.
   - **User 2**: Interested in Stock A and Stock B, wants to be notified for price decreases.
   - **User 3**: Interested in Stock B, wants to be notified when the price reaches $60.

3. **Scenario 1 (Stock A price increases):**

   - Stock A price changes from $120 to $130.
   - **User 1** should receive a notification because they are interested in Stock A and wanted price increases.
   - **User 2** should not receive a notification, as they are interested in Stock A but only for price decreases.
   - **User 3** should not receive a notification because they are only interested in Stock B.

4. **Scenario 2 (Stock B price reaches $60):**

   - Stock B price changes from $50 to $60.
   - **User 2** should receive a notification because they are interested in Stock B and wanted price decreases.
   - **User 3** should receive a notification because they set a price target for Stock B to reach $60.

5. **Dynamic Subscription/Unsubscription:**
   - **User 1** decides to stop receiving notifications for Stock A and unsubscribes.
   - **User 2** subscribes to updates for Stock C, with a preference for price increases.

---

#### **Objectives:**

- Implement a **Subject-Observer** pattern where the **StockMarket** is the subject and the **Users** are the observers.
- Allow the stock market to notify users based on their preferences when stock prices change.
- Provide dynamic subscription and unsubscription functionality for users to control which stocks they want to follow and how they want to be notified.

#### **Input:**

- A list of stock prices.
- A list of users with their preferences (e.g., which stocks they are interested in and their notification criteria).

#### **Output:**

- Notifications to users whenever a stock price changes, based on their preferences.

---

### **Use Case Example (Code Outline):**

1. **StockMarket (Subject):**

   - Holds a list of stocks and allows for price updates.
   - Notifies users when stock prices change.

2. **User (Observer):**

   - Subscribes to stock updates and specifies the notification criteria.

3. **Notification Handler:**
   - Handles different types of notifications (price increase, price decrease, or price threshold hit).

This problem statement can help in implementing a **real-time notification system** for stock prices, where the **Observer Design Pattern** is used to manage dynamic subscriptions and notifications efficiently.
