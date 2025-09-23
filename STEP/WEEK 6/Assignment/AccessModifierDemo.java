public class AccessModifierDemo {

    // ===================== Base Class: Tool =====================
    static class Tool {
        private String material;       // Private: not accessible directly
        protected double weight;       // Protected: accessible in subclass
        public String name;            // Public: accessible everywhere

        public Tool(String name, double weight, String material) {
            this.name = name;
            this.weight = weight;
            this.material = material;
            System.out.println("Tool constructor called");
        }

        // Getter for private field
        public String getMaterial() {
            return material;
        }

        // Setter for private field
        public void setMaterial(String material) {
            this.material = material;
        }

        public void displayToolInfo() {
            System.out.println("Tool Name: " + name);
            System.out.println("Weight: " + weight + " kg");
            System.out.println("Material: " + material);
        }
    }

    // ===================== Subclass: Hammer =====================
    static class Hammer extends Tool {
        private boolean hasRubberGrip;

        public Hammer(String name, double weight, String material, boolean hasRubberGrip) {
            super(name, weight, material); // Call Tool constructor
            this.hasRubberGrip = hasRubberGrip;
            System.out.println("Hammer constructor called");
        }

        public void displayHammerInfo() {
            // Accessing public field directly
            System.out.println("Hammer Name: " + name);

            // Accessing protected field directly
            System.out.println("Hammer Weight: " + weight + " kg");

            // Accessing private field via getter
            System.out.println("Hammer Material: " + getMaterial());

            // Accessing subclass-specific field
            System.out.println("Rubber Grip: " + (hasRubberGrip ? "Yes" : "No"));
        }
    }

    // ===================== Main Method =====================
    public static void main(String[] args) {
        Hammer myHammer = new Hammer("Claw Hammer", 1.5, "Steel", true);
        System.out.println("\n--- Tool Info ---");
        myHammer.displayToolInfo();

        System.out.println("\n--- Hammer Info ---");
        myHammer.displayHammerInfo();
    }
}