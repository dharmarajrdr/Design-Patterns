interface Drivable {

    void drive();
}

interface Startable {

    void start();
}

interface Vehicle extends Drivable, Startable {
    
}

class Sedan implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving a Sedan");
    }

    @Override
    public void start() {
        System.out.println("Starting a Sedan");
    }
}

class SUV implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving an SUV");
    }

    @Override
    public void start() {
        System.out.println("Starting an SUV");
    }
}

class Truck implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving a Truck");
    }

    @Override
    public void start() {
        System.out.println("Starting a Truck");
    }
}

// Factory class to create Vehicle objects
// Issue : Adding a new vehicle type requires modification of this factory class.
// This violates the Open/Closed Principle.
// Later this code will be bloated with more vehicle types.
/**
class VehicleFactory {

    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "sedan":
                return new Sedan();
            case "suv":
                return new SUV();
            case "truck":
                return new Truck();
            // Future vehicle types can be added here
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
*/

// So, instead of factory class, we can use factory interface and concrete factory classes for each vehicle type.
interface VehicleFactory {

    Vehicle createVehicle();
}

// Concrete factory classes for each vehicle type
class SedanFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Sedan();
    }
}

// Concrete factory classes for each vehicle type
class SUVFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new SUV();
    }
}

// Concrete factory classes for each vehicle type
class TruckFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}

class Solution {

    public static void main(String[] args) {
        
        // Without Factory Pattern
        Vehicle sedan = new Sedan();
        sedan.start();
        sedan.drive();
        Vehicle suv = new SUV();
        suv.start();
        suv.drive();
        Vehicle truck = new Truck();
        truck.start();
        truck.drive();

        // With Factory Pattern
        /**
            Vehicle sedanVehicle = VehicleFactory.createVehicle("sedan");
            sedanVehicle.start();
            sedanVehicle.drive();
            Vehicle suvVehicle = VehicleFactory.createVehicle("suv");
            suvVehicle.start();
            suvVehicle.drive();
            Vehicle truckVehicle = VehicleFactory.createVehicle("truck");
            truckVehicle.start();
            truckVehicle.drive();
        */

        // With Abstract Factory Pattern
        Vehicle sedanVehicle = new SedanFactory().createVehicle();
        sedanVehicle.start();
        sedanVehicle.drive();
        Vehicle suvVehicle = new SUVFactory().createVehicle();
        suvVehicle.start();
        suvVehicle.drive();
        Vehicle truckVehicle = new TruckFactory().createVehicle();
        truckVehicle.start();
        truckVehicle.drive();
    }
}