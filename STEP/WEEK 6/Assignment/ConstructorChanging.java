public class ConstructorChainingDemo {

    // ===================== Base Class: Light =====================
    static class Light {
        protected String type;
        protected int wattage;
        protected boolean isOn;

        // Constructor 1: Default
        public Light() {
            this("Incandescent", 60); // Chain to Constructor 2
            System.out.println("Light default constructor called");
        }

        // Constructor 2: Type and Wattage
        public Light(String type, int wattage) {
            this(type, wattage, false); // Chain to Constructor 3
            System.out.println("Light constructor with type and wattage called");
        }

        // Constructor 3: Full parameterized
        public Light(String type, int wattage, boolean isOn) {
            this.type = type;
            this.wattage = wattage;
            this.isOn = isOn;
            System.out.println("Light full constructor called");
        }

        public void toggle() {
            isOn = !isOn;
            System.out.println("Light toggled: " + (isOn ? "ON" : "OFF"));
        }

        public void displayStatus() {
            System.out.println("Type: " + type + ", Wattage: " + wattage + "W, Status: " + (isOn ? "ON" : "OFF"));
        }
    }

    // ===================== Subclass: LED =====================
    static class LED extends Light {
        private String color;
        private int lifespan;

        // Constructor 1: Default
        public LED() {
            this("White", 25000); // Chain to Constructor 2
            System.out.println("LED default constructor called");
        }

        // Constructor 2: LED-specific parameters
        public LED(String color, int lifespan) {
            super(); // Call Light default constructor
            this.color = color;
            this.lifespan = lifespan;
            System.out.println("LED constructor with color and lifespan called");
        }

        // Constructor 3: Full constructor
        public LED(String type, int wattage, boolean isOn, String color, int lifespan) {
            super(type, wattage, isOn); // Call Light full constructor
            this.color = color;
            this.lifespan = lifespan;
            System.out.println("LED full constructor called");
        }

        public void displayLEDInfo() {
            displayStatus(); // inherited method
            System.out.println("Color: " + color + ", Lifespan: " + lifespan + " hours");
        }
    }

    // ===================== Main Method =====================
    public static void main(String[] args) {
        System.out.println("=== Test 1: LED Default Constructor ===");
        LED