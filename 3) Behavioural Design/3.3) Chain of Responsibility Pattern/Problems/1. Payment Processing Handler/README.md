# Payment Processing Handler

### Requirements:
1. Client should be able to create a chain of payment handlers.
2. Each handler should be able to process a payment request or pass it to the next handler.
3. Handlers should be able to handle different payment methods (e.g., Credit Card, PayPal, Bank Transfer).
4. If a handler cannot process the request, it should pass it to the next handler in the chain.
5. If no handler can process the request, an appropriate message should be returned.
