# Chain of Responsibility Pattern

### Definition: (in simple words with examples)
The Chain of Responsibility Pattern is a behavioral design pattern that allows an object to pass a request along a chain of potential handlers until one of them handles the request. Each handler in the chain has the opportunity to process the request or pass it to the next handler.

### Example:
Imagine when you place an order in Zomato, the request goes through a series of steps before it is fulfilled:
1. **Order Placement**: You place an order through the app.
2. **Restaurant Processing**: The restaurant receives the order and prepares the food.
3. **Delivery Assignment**: Once the food is ready, the restaurant assigns a delivery person to pick up and deliver the order.
4. **Delivery Execution**: The delivery person picks up the food and delivers it to your address.
5. **Order Completion**: You receive the food and complete the order.

### Components of the Chain of Responsibility Pattern:
1. **Handler**: An interface or abstract class that defines the following methods:
   - `setNextHandler(Handler nextHandler)`: Sets the next handler in the chain.
   - `handleRequest(Request request)`: Processes the request or passes it to the next handler.
2. **Concrete Handlers**: Classes that implement the Handler interface and provide specific implementations for handling requests. Each concrete handler can either process the request or pass it to the next handler in the chain.
3. **Client**: The client initiates the request and sets up the chain of handlers.

