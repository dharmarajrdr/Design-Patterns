### Problem: **Text Formatting System**

You are building a text formatting system where you need to apply various formatting options to a string of text. These formatting options should be applied dynamically and in combination with each other.

### Requirements:

- You have a `Text` interface that defines a method to get the formatted text.
- You need to implement a **base text** class that implements this interface, representing plain unformatted text.
- You want to create decorators for different text formatting styles (e.g., **bold**, **italic**, **underline**).
- Each decorator should modify the text's appearance (e.g., add HTML tags or apply specific formatting rules).
- The decorators should be able to be chained, so a text string can be bold, italic, and underlined at the same time.

### Example:

- **Input**: "Hello, World!"
- **Output**: 
  - **Bold**: "<b>Hello, World!</b>"
  - **Italic**: "<i>Hello, World!</i>"
  - **Bold and Italic**: "<b><i>Hello, World!</i></b>"
  - **Bold, Italic, and Underlined**: "<b><i><u>Hello, World!</u></i></b>"

### Steps:

1. Define the `Text` interface with a method `String getText()`.
2. Create a concrete class `PlainText` that implements `Text` and returns the plain input text.
3. Implement decorators for `Bold`, `Italic`, and `Underline`. Each decorator will add its respective formatting.
4. Decorators should wrap around the `Text` object and apply the formatting in combination with the original text.
5. Chain decorators to apply multiple formatting styles to the same text.

### Expected Result:
By using the decorator pattern, you should be able to dynamically apply various text formatting styles without modifying the core text object. Each decorator should only add its specific behavior (e.g., adding HTML tags for bold, italic, or underline), while the underlying text remains flexible.
