### Problem Statement: Drawing Application

You are building a **drawing application** that uses a `ShapeDrawer` interface to draw various shapes:

```java
interface ShapeDrawer {
    void draw(String shapeType);
}
```

Currently, your application can handle simple shapes like **circles** and **rectangles**. However, you need to integrate a **legacy graphics library** that draws polygons using a completely different method:

```java
class LegacyPolygonDrawer {
    public void drawPolygon(int sides, String name) {
        System.out.println("Drawing a " + name + " with " + sides + " sides.");
    }
}
```

### Requirement

Use the **Adapter Design Pattern** to make the `LegacyPolygonDrawer` compatible with the `ShapeDrawer` interface. Your system should work as follows:

---

### Sample Input and Output

1. **Input**: `shapeDrawer.draw("circle");`  
   **Output**: `Drawing a circle.`

2. **Input**: `shapeDrawer.draw("rectangle");`  
   **Output**: `Drawing a rectangle.`

3. **Input**: `shapeDrawer.draw("triangle");`  
   **Output**: `Drawing a triangle with 3 sides.`

4. **Input**: `shapeDrawer.draw("pentagon");`  
   **Output**: `Drawing a pentagon with 5 sides.`

---

### Additional Constraints

- For shapes like "circle" and "rectangle," the `ShapeDrawer` should use default logic.
- For polygons like "triangle," "pentagon," etc., the `ShapeDrawer` should delegate to the `LegacyPolygonDrawer` through the adapter.
