package week3.practice_problems;

public class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isRunning;

    // Constructor
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }

    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started!");
    }

    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped!");
    }

    public void displayInfo() {
        System.out.println("Car Info → Brand: " + brand + ", Model: " + model +
                ", Year: " + year + ", Color: " + color + ", Running: " + isRunning);
    }

    public int getAge() {
        return java.time.Year.now().getValue() - year;
    }

    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Corolla", 2018, "White");
        Car c2 = new Car("Tesla", "Model 3", 2021, "Red");
        Car c3 = new Car("Ford", "Mustang", 2015, "Blue");

        c1.startEngine();
        c1.displayInfo();
        System.out.println("Age: " + c1.getAge() + " years\n");

        c2.displayInfo();
        c2.stopEngine();

        c3.startEngine();
        c3.displayInfo();
    }
}
