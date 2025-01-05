**Flyweight Design Pattern in Java**

The Flyweight Design Pattern is a structural design pattern that focuses on minimizing memory usage by sharing as much data as possible with similar objects. It is particularly useful when a large number of similar objects are used, and the cost of creating and maintaining these objects becomes prohibitive.

### Key Characteristics

1. **Intrinsic State**: Information that is shared and stored in the Flyweight object.
2. **Extrinsic State**: Information that varies with each object and must be passed to the Flyweight object.
3. **Factory Method**: Often used to manage Flyweight objects and ensure proper sharing.

---

### Issue

In scenarios where a system needs to handle a _large number of objects with similar data_, the memory overhead can be significant. For example, consider a text editor displaying millions of characters, where each character is represented as an object containing attributes like font, size, and color. Without optimization, this could lead to excessive memory consumption.

### What the Flyweight Design Pattern Solves

The Flyweight pattern addresses this problem by **sharing common parts of the object's state** (intrinsic state) and externalizing the varying parts (extrinsic state). This reduces the number of objects in memory and optimizes resource usage.

---

### Real-world Example

In a graphical application, objects like "Tree" in a forest can share common data such as the type of tree, texture, and height, while location-specific details (like coordinates) remain extrinsic. By applying the Flyweight pattern, only one instance of each type of tree is created and shared, significantly reducing memory usage.

---

### Example Implementation in Java

```java
@Getter
@AllArgsConstructor
class ChessUser {
    private final UserIntrinsicState intrinsicState;
    private final UserExtrinsicState extrinsicState;
}

enum Colour {
    BLACK, WHITE
}

@Getter
@AllArgsConstructor
class UserIntrinsicState {
    private final String name;
    private final int age;
    private final String gender;
    private final String email;
    private final String phoneNumber;
    private final Byte[] photo;
}

@Getter
@RequiredArgsConstructor
public class UserExtrinsicState {
    private final Colour colour; // Represents the chess piece color (BLACK or WHITE)
    private final int currentGameStreak; // Represents the user's current game streak
    private final UserIntrinsicState intrinsicState; // Reference to the intrinsic state
}

interface FlyweightRegistry {

    void addFlyweight(UserIntrinsicState flyweight);

    UserIntrinsicState getFlyweight(String email);
}

// Factory class to manage Flyweight objects
class UserFlyweightFactory implements FlyweightRegistry {

    private static final Map<String, UserIntrinsicState> userRegistry = new HashMap<>();    // String - email

    @Override
    public void addFlyweight(UserIntrinsicState flyweight) {
        String email = flyweight.getEmail();
        if (!userRegistry.containsKey(email)) {
            userRegistry.put(email, flyweight);
        }
    }

    @Override
    public UserIntrinsicState getFlyweight(String email) {
        return userRegistry.get(email);
    }
}

```

---

### Interview Questions

1. **What is the Flyweight Design Pattern?**

   - Explain the concept and purpose of the Flyweight pattern.

2. **What are the key components of the Flyweight Design Pattern?**

   - Intrinsic state, extrinsic state, Flyweight interface, Flyweight factory.

3. **How does the Flyweight Design Pattern optimize memory usage?**

   - By sharing intrinsic state and externalizing extrinsic state.

4. **What are the trade-offs of using the Flyweight Design Pattern?**

   - Increased complexity in managing extrinsic data and ensuring thread safety.

5. **Can you give a real-world scenario where the Flyweight pattern would be useful?**

   - Example: Rendering large numbers of graphical elements like characters in a text editor or trees in a forest.

6. **How is the Flyweight Design Pattern implemented in Java?**

   - Discuss the implementation with an example, including the role of the factory class.

7. **What is the difference between Flyweight and Singleton patterns?**

   - Flyweight allows multiple shared objects, while Singleton ensures only one instance of a class.

8. **How do you ensure thread safety in the Flyweight pattern?**

   - Use synchronized methods or concurrent collections to manage Flyweight objects.

9. **What are intrinsic and extrinsic states in Flyweight? Provide examples.**

   - Intrinsic: Shared data (e.g., tree type); Extrinsic: Context-specific data (e.g., tree location).

10. **What are some disadvantages of the Flyweight Design Pattern?**
    - Increased complexity, reliance on external management of extrinsic data, and potential thread-safety issues.

---

### Conclusion

The Flyweight Design Pattern is an effective solution for optimizing memory usage in applications requiring numerous similar objects. By understanding its principles and trade-offs, developers can leverage it to build more efficient and scalable systems.
