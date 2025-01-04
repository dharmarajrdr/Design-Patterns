### **Problem Statement: Customizable Pizza Orders**

You are tasked with building a system for a pizza shop that allows customers to customize their pizzas. The shop offers three basic types of pizzas:  

1. **Margherita Pizza**  
2. **Pepperoni Pizza**  
3. **Veggie Pizza**  

Customers can customize their pizzas by adding any combination of the following toppings:  
- **Cheese**  
- **Olives**  
- **Mushrooms**  
- **Extra Sauce**  

Each topping has an additional cost, and the system must dynamically calculate the total price and provide a detailed description of the pizza, including all the toppings.

---

### **Requirements**  

1. Each pizza type should have its own base price and description.  
2. Toppings can be added dynamically without modifying the existing pizza or topping classes.  
3. The system should calculate the total cost of the pizza with all the selected toppings.  
4. The system should display a detailed description of the pizza, listing all the added toppings.  

---

### **Example Output**

1. **Order 1**:  
   - Pizza: Margherita  
   - Toppings: Cheese, Olives  
   - **Output**:  
     Description: *Margherita Pizza, Cheese, Olives*  
     Cost: $8.5  

2. **Order 2**:  
   - Pizza: Pepperoni  
   - Toppings: Mushrooms, Extra Sauce  
   - **Output**:  
     Description: *Pepperoni Pizza, Mushrooms, Extra Sauce*  
     Cost: $10.0  
