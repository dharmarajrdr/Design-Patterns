# Abstract Factory Pattern

You are tasked with creating a car manufacturing system that can produce different types of cars (e.g., Sedan, SUV, Truck) from different manufacturers (e.g., Toyota, Ford, BMW). Upon introducing a new manufacturer, the system should be able to produce all types of cars from that manufacturer without modifying existing code.
Means, you are not allowed to change the existing factory classes or car classes when a new manufacturer is added.

#### With Factory Pattern:

```java
class CarFactory {
    public Car createCar(String carType) {
        switch (carType) {
            case "Sedan":
                return new Sedan();
            case "Truck":
                return new Truck();
            // Existing code modified when a new manufacturer is added.
            // Later this code will become hard to maintain.
            default:
                return null;
        }
    }
}
```

#### Solution:

To solve this problem, we can use the Abstract Factory Pattern. This pattern allows us to create families of related or dependent objects without specifying their concrete classes. In this case, we will create an abstract factory for car manufacturers and concrete factories for each manufacturer.

```java
interface Car {
    void drive();
}

// Create concrete class for new brand
class Sedan implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a sedan...");
    }
}

// Create Abstract Factory interface
interface CarFactory {
    Car createCar();
}

// Create Abstract Factory class
class SedanFactory extends CarFactory {
    public Car createCar() {
        return new Sedan();
    }
}

class Main {

    public static void main(String[] args) {
        
        CarFactory sedanFactory = new SedanFactory();
        Car sedan = sedanFactory.createCar();
        sedan.drive(); // Output: Driving a sedan...
    }
}
```

* No code is modified when a new manufacturer is added.