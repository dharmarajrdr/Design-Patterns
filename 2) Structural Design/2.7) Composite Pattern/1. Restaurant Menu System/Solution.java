import java.util.ArrayList;
import java.util.List;

interface Menu {

    void print(String indent);
    double getPrice();
}

class MenuItem implements Menu {

    private final String name;
    private final double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "🍽️ " + name + " - ₹" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class ItemGroup implements Menu {

    private final String name;
    List<Menu> items = new ArrayList<>();

    public ItemGroup(String name) {
        this.name = name;
    }

    public void addItem(Menu menu) {
        items.add(menu);
    }

    public void removeItem(Menu menu) {
        items.remove(menu);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + name);
        for(Menu item: items) {
            item.print(indent + "    ");
        }
    }

    @Override
    public double getPrice() {
        
        return items.stream().mapToDouble(Menu::getPrice).sum();
    }
}

class Solution {

    private static void briyani() {
        ItemGroup vegBriyaniItems = new ItemGroup("Veg Biryani Items");
        vegBriyaniItems.addItem(new MenuItem("Veg Biryani", 180));
        vegBriyaniItems.addItem(new MenuItem("Paneer Biryani", 220));
        
        ItemGroup nonVegBriyaniItems = new ItemGroup("Non-Veg Biryani Items");
        nonVegBriyaniItems.addItem(new MenuItem("Chicken Biryani", 250));
        nonVegBriyaniItems.addItem(new MenuItem("Mutton Biryani", 300));

        ItemGroup briyaniItems = new ItemGroup("Biryani Items");
        briyaniItems.addItem(vegBriyaniItems);
        briyaniItems.addItem(nonVegBriyaniItems);

        briyaniItems.print("");
    }

    private static void noodles() {
        ItemGroup vegNoodlesItems = new ItemGroup("Veg Noodles Items");
        vegNoodlesItems.addItem(new MenuItem("Veg Hakka Noodles", 120));
        vegNoodlesItems.addItem(new MenuItem("Paneer Noodles", 150));
        
        ItemGroup nonVegNoodlesItems = new ItemGroup("Non-Veg Noodles Items");
        nonVegNoodlesItems.addItem(new MenuItem("Chicken Noodles", 180));
        nonVegNoodlesItems.addItem(new MenuItem("Egg Noodles", 160));

        ItemGroup noodlesItems = new ItemGroup("Noodles Items");
        noodlesItems.addItem(vegNoodlesItems);
        noodlesItems.addItem(nonVegNoodlesItems);

        noodlesItems.print("");
    }

    private static void gravies() {
        ItemGroup vegGravyItems = new ItemGroup("Veg Gravy Items");
        vegGravyItems.addItem(new MenuItem("Paneer Butter Masala", 220));
        vegGravyItems.addItem(new MenuItem("Kadai Paneer", 250));

        ItemGroup specialVegGravyItems = new ItemGroup("Special Veg Gravy Items");
        specialVegGravyItems.addItem(new MenuItem("Dal Makhani", 240));
        specialVegGravyItems.addItem(new MenuItem("Paneer Lababdar", 260));
        vegGravyItems.addItem(specialVegGravyItems);

        ItemGroup nonVegGravyItems = new ItemGroup("Non-Veg Gravy Items");
        nonVegGravyItems.addItem(new MenuItem("Butter Chicken", 280));
        nonVegGravyItems.addItem(new MenuItem("Chicken Tikka Masala", 300));

        ItemGroup gravyItems = new ItemGroup("Gravy Items");
        gravyItems.addItem(vegGravyItems);
        gravyItems.addItem(nonVegGravyItems);

        gravyItems.print("");
    }

    public static void main(String[] args) {
    
        briyani();
        noodles();
        gravies(); // with many sub gravies    
    }
}