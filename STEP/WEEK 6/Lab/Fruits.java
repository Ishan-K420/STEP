// Parent class
class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
}

// Child class
class Apple extends Fruit {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste); // Call parent constructor
        this.variety = variety;
    }

    public void displayInfo() {
        System.out.println("Apple Color: " + color);
        System.out.println("Apple Taste: " + taste);
        System.out.println("Apple Variety: " + variety);
    }
}

// Test class
public class Fruits {
    public static void main(String[] args) {
        Apple myApple = new Apple("Red", "Sweet", "Fuji");
        myApple.displayInfo();
    }
}