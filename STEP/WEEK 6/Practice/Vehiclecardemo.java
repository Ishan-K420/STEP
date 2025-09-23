import java.util.UUID;

public class VehicleCarDemo {

    // ===================== Vehicle Class =====================
    static class Vehicle {
        // Protected fields for inheritance
        protected String brand;
        protected String model;
        protected int year;
        protected String engineType;

        // Private fields with encapsulation
        private String registrationNumber;
        private boolean isRunning;

        // Default constructor
        public Vehicle() {
            this.brand = "Generic";
            this.model = "ModelX";
            this.year = 2000;
            this.engineType = "Petrol";
            this.registrationNumber = UUID.randomUUID().toString();
            this.isRunning = false;
            System.out.println("Vehicle default constructor called");
        }

        // Parameterized constructor
        public Vehicle(String brand, String model, int year, String engineType) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.engineType = engineType;
            this.registrationNumber = UUID.randomUUID().toString();
            this.isRunning = false;
            System.out.println("Vehicle parameterized constructor called");
        }

        // Basic operations
        public void start() {
            isRunning = true;
            System.out.println("Vehicle started");
        }

        public void stop() {
            isRunning = false;
            System.out.println("Vehicle stopped");
        }

        public String getVehicleInfo() {
            return "Brand: " + brand + ", Model: " + model + ", Year: " + year +
                   ", Engine: " + engineType + ", Reg#: " + registrationNumber +
                   ", Running: " + isRunning;
        }

        public void displaySpecs() {
            System.out.println("Vehicle Specs:");
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
            System.out.println("Engine Type: " + engineType);
        }

        // Getters and setters
        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public void setRegistrationNumber(String regNum) {
            this.registrationNumber = regNum;
        }

        public boolean isRunning() {
            return isRunning;
        }
    }

    // ===================== Car Class =====================
    static class Car extends Vehicle {
        // Car-specific fields
        private int numberOfDoors;
        private String fuelType;
        private String transmissionType;

        // Default constructor
        public Car() {
            super(); // Calls Vehicle default constructor
            this.numberOfDoors = 4;
            this.fuelType = "Petrol";
            this.transmissionType = "Manual";
            System.out.println("Car default constructor called");
        }

        // Parameterized constructor
        public Car(String brand, String model, int year, String engineType,
                   int numberOfDoors, String fuelType, String transmissionType) {
            super(brand, model, year, engineType); // Calls Vehicle parameterized constructor
            this.numberOfDoors = numberOfDoors;
            this.fuelType = fuelType;
            this.transmissionType = transmissionType;
            System.out.println("Car parameterized constructor called");
        }

        // Overridden methods
        @Override
        public void start() {
            super.start(); // Call Vehicle's start
            System.out.println("Car systems initialized");
        }

        @Override
        public void displaySpecs() {
            super.displaySpecs(); // Show Vehicle specs
            System.out.println("Car Specs:");
            System.out.println("Doors: " + numberOfDoors);
            System.out.println("Fuel Type: " + fuelType);
            System.out.println("Transmission: " + transmissionType);
        }

        // Car-specific methods
        public void openTrunk() {
            System.out.println("Trunk opened");
        }

        public void playRadio() {
            System.out.println("Radio playing music");
        }
    }

    // ===================== Main Method =====================
    public static void main(String[] args) {
        System.out.println("=== Default Constructor Test ===");
        Car defaultCar = new Car();
        defaultCar.start();
        defaultCar.displaySpecs();
        defaultCar.openTrunk();
        defaultCar.playRadio();
        System.out.println(defaultCar.getVehicleInfo());

        System.out.println("\n=== Parameterized Constructor Test ===");
        Car customCar = new Car("Toyota", "Camry", 2022, "Hybrid", 4, "Hybrid", "Automatic");
        customCar.start();
        customCar.displaySpecs();
        customCar.stop();
        System.out.println(customCar.getVehicleInfo());
    }
}