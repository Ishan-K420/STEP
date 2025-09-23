// Parent class
class Phone {
    protected String brand;
    protected String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone constructor called");
    }
}

// Child class
class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model); // Call parent constructor
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone constructor called");
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("OS: " + operatingSystem);
    }
}

// Test class
public class Phones {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("Samsung", "Galaxy S21", "Android");
        myPhone.displayDetails();
    }
}