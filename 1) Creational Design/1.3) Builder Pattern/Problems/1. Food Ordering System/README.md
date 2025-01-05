### Problem Statement: Food Ordering System

You are tasked with designing a system that generates complex objects, such as a customizable **Meal** in a restaurant ordering system. Each meal consists of multiple components, such as:

- **Main course** (e.g., pizza, burger, or pasta)
- **Side dish** (e.g., fries, salad, or soup)
- **Drink** (e.g., soda, juice, or water)
- **Dessert** (optional, e.g., cake or ice cream)
- **Special instructions** (e.g., gluten-free, extra spicy)

The following requirements should be met:

1. The process of creating a **Meal** should be flexible and allow variations.
2. The **Meal** object should be constructed step-by-step, so customers can choose what they want.
3. The client should not be exposed to the internal details of how a **Meal** is assembled.
4. It should be easy to add new meal components (e.g., a new type of dessert) without modifying existing code.

### Objective:

Design a system using the **Builder Design Pattern** to handle the construction of **Meal** objects, ensuring that the system is modular, scalable, and maintains separation between object construction and representation.
