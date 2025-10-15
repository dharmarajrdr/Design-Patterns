
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Observer
interface Observer {
    void onUpdate(String restaurantName);
}

// Subject
interface Subject {
    void registerObserver(String restaurantName, Observer o);
    void removeObserver(String restaurantName, Observer o);
    void notifyObservers(String restaurantName);
}

// Data class
class Menu {
    private Map<String, Double> items = new HashMap<>();

    public void addItem(String item, double price) {
        items.put(item, price);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public Map<String, Double> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}

// Concrete Subject
class Restaurant implements Subject {

    private Map<String, Menu> restaurantMenuMap = new HashMap<>();
    private Map<String, List<Observer>> observers = new HashMap<>();

    @Override
    public void registerObserver(String restaurantName, Observer o) {
        observers.computeIfAbsent(restaurantName, k -> new ArrayList<>()).add(o);
    }

    @Override
    public void removeObserver(String restaurantName, Observer o) {
        List<Observer> list = observers.get(restaurantName);
        if (list != null) {
            list.remove(o);
            if (list.isEmpty()) observers.remove(restaurantName);
        }
    }

    @Override
    public void notifyObservers(String restaurantName) {
        List<Observer> allObservers = observers.get(restaurantName);
        if (allObservers != null) {
            for (Observer o : allObservers) {
                o.onUpdate(restaurantName);  // Pull-based
            }
        }
    }

    public Menu getMenu(String restaurantName) {
        return restaurantMenuMap.get(restaurantName);
    }

    public void updateMenu(String restaurantName, String item, double price) {
        Menu menu = restaurantMenuMap.computeIfAbsent(restaurantName, k -> new Menu());
        menu.addItem(item, price);
        notifyObservers(restaurantName);
    }
}

// Concrete Observer
class Customer implements Observer {

    private String name;
    private Restaurant restaurant;

    public Customer(String name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
    }

    @Override
    public void onUpdate(String restaurantName) {
        System.out.println(String.format("\n🍽️ Hello %s! '%s' menu got updated!", name, restaurantName));
        Menu updatedMenu = restaurant.getMenu(restaurantName); // pull-based
        System.out.println("📜 Updated Menu: " + updatedMenu);
    }
}

// Driver
class Solution {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        Observer dharma = new Customer("Dharma", restaurant);
        Observer mohan = new Customer("Mohan", restaurant);

        restaurant.registerObserver("Star Briyani", dharma);
        restaurant.registerObserver("Dominos", mohan);

        restaurant.updateMenu("Star Briyani", "Chicken Briyani", 299.0);
        restaurant.updateMenu("Dominos", "Garlic Bread", 149.0);
    }
}