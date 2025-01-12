
interface ShapeDrawer {

    void draw(String shapeType);
}

// Adaptee (Legacy system)
class LegacyPolygonDrawer {

    public void drawPolygon(int sides, String name) {
        System.out.println("Drawing a " + name + " with " + sides + " sides.");
    }
}

// Adapter class
class ShapeAdapter implements ShapeDrawer {

    private LegacyPolygonDrawer polygonDrawer;

    public ShapeAdapter() {
        this.polygonDrawer = new LegacyPolygonDrawer();
    }

    @Override
    public void draw(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                System.out.println("Drawing a circle.");
                break;
            case "rectangle":
                System.out.println("Drawing a rectangle.");
                break;
            case "triangle":
                polygonDrawer.drawPolygon(3, "triangle");
                break;
            case "pentagon":
                polygonDrawer.drawPolygon(5, "pentagon");
                break;
            default:
                System.out.println("Unknown shape: " + shapeType);
        }
    }
}

// Client code
public class Solution {

    public static void main(String[] args) {
        ShapeDrawer shapeDrawer = new ShapeAdapter();

        shapeDrawer.draw("circle");     // Output: Drawing a circle.
        shapeDrawer.draw("rectangle");  // Output: Drawing a rectangle.
        shapeDrawer.draw("triangle");   // Output: Drawing a triangle with 3 sides.
        shapeDrawer.draw("pentagon");   // Output: Drawing a pentagon with 5 sides.
        shapeDrawer.draw("hexagon");    // Output: Unknown shape: hexagon.
    }
}
