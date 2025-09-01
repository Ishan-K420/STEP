package week3.practice_problems;

class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    public void startVehicle() { System.out.println(make + " " + model + " started."); }
    public void stopVehicle() { System.out.println(make + " " + model + " stopped."); }
    public void refuel(double amount) { fuelLevel += amount; }
    public void displayVehicleInfo() {
        System.out.println(year + " " + make + " " + model + " | Fuel: " + fuelLevel + "L");
    }
}

// Renamed from Car → CarVehicle to avoid duplicate class error
class CarVehicle extends Vehicle {
    public CarVehicle(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
}

class Truck extends Vehicle {
    public Truck(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new CarVehicle("Honda", "Civic", 2019, 20),
                new Truck("Volvo", "FH16", 2020, 100),
                new Motorcycle("Yamaha", "R15", 2022, 10)
        };

        for (Vehicle v : vehicles) {
            v.startVehicle();
            v.displayVehicleInfo();
        }
    }
}
