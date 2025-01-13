### Problem Statement: **Online Shopping System - Order Processing Facade**

You are building an **online shopping platform** that allows customers to browse items, add them to the cart, and place orders. The platform has multiple subsystems for managing different tasks:

1. **Payment Service**: Handles payments through different gateways.
2. **Inventory Service**: Manages product availability and inventory.
3. **Shipping Service**: Calculates shipping charges and schedules deliveries.
4. **Email Notification Service**: Sends confirmation emails and shipping updates.

### Requirement:

Design a **Facade** class called `OrderProcessingFacade` that simplifies the interaction for the customers. The facade should expose a single method `processOrder(Customer customer, List<Item> items)` that takes care of:

- Validating the customer's order.
- Checking product availability through the **Inventory Service**.
- Processing payment via the **Payment Service**.
- Scheduling delivery through the **Shipping Service**.
- Sending an email confirmation via the **Email Notification Service**.

The customers only need to interact with the `OrderProcessingFacade` to place an order, without worrying about the details of the individual subsystems.
