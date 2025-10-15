### **Problem Statement: Restaurant Notifier**

You are tasked with designing a notification system for a food delivery application like Swiggy. The system should allow users to subscribe to notifications about their favorite restaurants, cuisines, or specific dishes. Whenever there are updates such as new menu items, discounts, or special offers from the subscribed entities, the users should receive timely notifications.

### **Requirements:**

1. **User Subscription:**
   - Users should be able to subscribe to notifications for specific restaurants, cuisines, or dishes.
   - Users can manage their subscriptions (add/remove) at any time.

2. **Notification Triggers:**
   - The system should trigger notifications for the following events:
     - New menu items added to a subscribed restaurant.
     - Discounts or special offers available for subscribed cuisines or dishes.
     - Any other relevant updates from the subscribed entities.

3. **Notification Delivery:**
   - Notifications should be delivered to users in real-time.
   - Users should receive notifications through their preferred channels (e.g., in-app notifications, SMS, email).

4. **Scalability:**
   - The system should be able to handle a large number of users and subscriptions efficiently.
   - The design should allow for easy addition of new notification types or channels in the future.

### **Example:**
1. **User Subscriptions:**
   - User A subscribed to notify any offers from Restaurant "Golcondas Briyani" and new menu items.
   - User B subscribed to notify discounts on "Star Briyani".