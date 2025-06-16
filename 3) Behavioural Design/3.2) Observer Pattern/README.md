### **Observer Design Pattern:**

#### **Definition:**

The **Observer Design Pattern** is a behavioral design pattern that allows a subject to notify its observers about changes without knowing who or what those observers are. The pattern defines a one-to-many relationship, where a subject (also called a "publisher") maintains a list of observers (also called "subscribers"), and automatically notifies them of any state changes, typically by calling one of their methods.

The pattern involves:

1. **Subject** (or Observable): The object that holds the state and sends notifications to the observers.
2. **Observer**: The objects that need to be updated when the state of the subject changes.
3. **ConcreteSubject**: A class that implements the subject and maintains the state that changes.
4. **ConcreteObserver**: A class that implements the observer interface and reacts to state changes.

---

#### **When and Why to Use the Observer Pattern:**

**When to Use:**

1. **When you need to maintain consistency** between related objects without making the subject aware of the concrete observers. This is especially useful when one object (subject) changes state, and you want all dependent objects (observers) to be notified and updated automatically.
2. **When a change to one object requires changing others**, and you don't want the subject to know about how many objects are affected or how they react to the change.
3. **When multiple objects need to listen to changes in a single object**, for example, when different parts of an application need to be updated when a central data source changes (like UI updates in a weather app when the weather changes).
4. **When the observers should be able to subscribe or unsubscribe dynamically** to the subject, allowing for flexibility in how updates are handled.

**Why to Use:**

1. **Loose Coupling**: The observer pattern decouples the subject and observers, meaning the subject doesn’t need to know who or how many observers exist. This promotes flexibility and maintainability.
2. **Dynamic Updates**: Observers can dynamically subscribe or unsubscribe, allowing real-time updates to propagate across multiple objects.
3. **Automatic Notification**: When the subject’s state changes, all registered observers are notified automatically without the subject needing to keep track of them explicitly.

---

#### **Before Using the Observer Pattern:**

**Problem Scenario:**

- You have a subject (or central data source) that changes state, and multiple dependent objects (observers) need to react to that change. However, you have to manually update all observers every time the subject’s state changes, which becomes error-prone and difficult to maintain.
- There is a **tight coupling** between the subject and observers, making it difficult to add new types of observers or change the observer behavior without modifying the subject itself.
- If observers need to be added, removed, or altered, changes need to be made to the subject code, violating the **open-closed principle**.

**Example (Before):**

```java
public class WeatherStation {
    private double temperature;
    private double humidity;

    private WeatherDisplay display;

    public WeatherStation() {
        this.display = new WeatherDisplay(); // Only one observer
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        updateDisplay();
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
        updateDisplay();
    }

    private void updateDisplay() {
        display.update(temperature, humidity); // Manually notify the observer
    }
}

public class WeatherDisplay {
    public void update(double temperature, double humidity) {
        System.out.println("Updated Weather: " + temperature + "°C, " + humidity + "%");
    }
}
```

In this case, if more observers need to be notified (e.g., logging, analytics), you have to modify the `WeatherStation` class to explicitly update them, which creates tight coupling between the subject and observers.

---

#### **After Using the Observer Pattern:**

**Solution Scenario:**

- The subject (`WeatherStation`) maintains a list of observers and notifies them when its state changes. Observers can subscribe or unsubscribe from the subject without modifying the subject’s code.
- This improves **maintainability**, as new observers can be added without changing the subject, and observers can react to changes independently.

**Example (After):**

```java
// Subject (Observable)
public class WeatherStation {
    private double temperature;
    private double humidity;
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity); // Notify all observers
        }
    }
}

// Observer
public interface Observer {
    void update(double temperature, double humidity);
}

// ConcreteObserver
public class WeatherDisplay implements Observer {
    @Override
    public void update(double temperature, double humidity) {
        System.out.println("Updated Weather: " + temperature + "°C, " + humidity + "%");
    }
}

public class WeatherLogger implements Observer {
    @Override
    public void update(double temperature, double humidity) {
        System.out.println("Logging Weather Data: " + temperature + "°C, " + humidity + "%");
    }
}

// Client Code
public class Solution {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // Create observers
        WeatherDisplay display = new WeatherDisplay();
        WeatherLogger logger = new WeatherLogger();

        // Subscribe observers
        weatherStation.addObserver(display);
        weatherStation.addObserver(logger);

        // Change weather data
        weatherStation.setTemperature(25.0);
        weatherStation.setHumidity(60.0);

        // Remove observer
        weatherStation.removeObserver(logger);

        // Change weather data again
        weatherStation.setTemperature(30.0);
    }
}
```

**In this case:**

- The **WeatherStation** (subject) maintains a list of observers and notifies them whenever the weather data changes.
- **Observers** (like `WeatherDisplay` and `WeatherLogger`) react to the changes independently.
- Observers can be dynamically added or removed without modifying the `WeatherStation` class.

---

### **Summary of Before and After:**

**Before Using Observer Pattern:**

- The subject has explicit knowledge of its observers, and it manually updates them.
- Adding or removing observers requires modifying the subject code.
- Tight coupling between the subject and observers.

**After Using Observer Pattern:**

- The subject maintains a list of observers and notifies them when its state changes.
- Observers can subscribe and unsubscribe independently, without affecting the subject.
- Loose coupling between the subject and its observers, improving flexibility and maintainability.

---

### **Conclusion:**

The **Observer Design Pattern** is ideal for cases where multiple objects need to be notified about changes to a central object (subject) without creating tight dependencies between them. It promotes **loose coupling**, making it easier to add new observers or modify their behavior without affecting the subject. The pattern is commonly used in event-driven systems (e.g., GUIs, real-time updates), and it provides a scalable solution to manage state changes across multiple objects.
