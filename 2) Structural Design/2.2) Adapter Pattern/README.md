### **Adapter Design Pattern**

The **Adapter Design Pattern** is a structural pattern that allows incompatible interfaces to work together. It acts as a bridge between two classes, enabling the client code to use a class that has an incompatible interface by converting one interface into another.

---

### **When to Use the Adapter Design Pattern**

1. **Incompatibility Between Interfaces**:

   - Use the adapter pattern when you have a class that needs to work with an existing interface but has a different method signature.

2. **Integrating Third-Party or Legacy Systems**:

   - When integrating a third-party library or legacy system with your code, and their interfaces don't match.

3. **Reusing Existing Code**:

   - When you want to reuse an existing class without modifying its code, especially if it’s not feasible to change the existing code (e.g., third-party libraries).

4. **Providing a Unified Interface**:
   - When you want to create a common interface for a set of classes with different interfaces.

---

### **Why Use the Adapter Design Pattern**

1. **Increases Flexibility**:

   - Adapters allow systems with incompatible interfaces to communicate without modifying their source code.

2. **Promotes Reusability**:

   - Allows you to use existing classes without requiring major changes, reducing redundancy and improving maintainability.

3. **Improves Separation of Concerns**:

   - Keeps the client code decoupled from the specific implementation of third-party or legacy systems.

4. **Simplifies Testing and Maintenance**:
   - With a unified interface, testing and maintaining the code becomes simpler and more consistent.

---

### **Before and After Using the Adapter Design Pattern**

#### **Before Adapter Pattern**

- You have a client that requires a specific interface (`ShapeDrawer`).
- The legacy system or third-party library has a different interface (`LegacyPolygonDrawer`).
- The client cannot directly use the legacy system without modifying its code or writing custom logic every time.

##### **Example Without Adapter**

```java
class Client {
    public void drawCircle() {
        System.out.println("Drawing a circle.");
    }

    public void drawPolygon() {
        LegacyPolygonDrawer legacyPolygonDrawer = new LegacyPolygonDrawer();
        legacyPolygonDrawer.drawPolygon(5, "pentagon");
    }
}
```

- **Problem**: The client directly interacts with both the existing and legacy systems, leading to tight coupling and redundancy.

---

#### **After Adapter Pattern**

- An adapter class (`ShapeAdapter`) bridges the gap between the client (`ShapeDrawer`) and the legacy system (`LegacyPolygonDrawer`).
- The client only interacts with the `ShapeDrawer` interface, and the adapter handles the conversion.

##### **Example With Adapter**

```java
interface ShapeDrawer {
    void draw(String shapeType);
}

class ShapeAdapter implements ShapeDrawer {
    private LegacyPolygonDrawer legacyPolygonDrawer;

    public ShapeAdapter() {
        this.legacyPolygonDrawer = new LegacyPolygonDrawer();
    }

    @Override
    public void draw(String shapeType) {
        if (shapeType.equals("circle")) {
            System.out.println("Drawing a circle.");
        } else if (shapeType.equals("pentagon")) {
            legacyPolygonDrawer.drawPolygon(5, "pentagon");
        }
    }
}
```

- **Benefits**:
  - The client is now decoupled from the legacy system.
  - Unified and flexible interface (`ShapeDrawer`).
  - No need for major modifications to the legacy system.
