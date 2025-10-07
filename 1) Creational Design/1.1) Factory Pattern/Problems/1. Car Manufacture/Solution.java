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
        Vehicle factorySedan = VehicleFactory.createVehicle("sedan");
        factorySedan.start();
        factorySedan.drive();
        Vehicle factorySUV = VehicleFactory.createVehicle("suv");
        factorySUV.start();
        factorySUV.drive();
        Vehicle factoryTruck = VehicleFactory.createVehicle("truck");
        factoryTruck.start();
        factoryTruck.drive();
    }
}