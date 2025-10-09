public class FoodDeliveryApp {
    
    // Basic delivery - just distance
    public double calculateDelivery(double distance) {
        double cost = distance * 2.0;
        System.out.println("Basic Delivery: Distance " + distance + "km = $" + cost);
        return cost;
    }
    
    // Premium delivery - distance + priority fee
    public double calculateDelivery(double distance, double priorityFee) {
        double cost = (distance * 2.0) + priorityFee;
        System.out.println("Premium Delivery: Distance " + distance + "km ($" + (distance * 2.0) + ") + Priority fee ($" + priorityFee + ") = $" + cost);
        return cost;
    }
    
    // Group delivery - distance + number of orders discount
    public double calculateDelivery(double distance, int numOrders) {
        double baseCost = distance * 2.0;
        double discount = numOrders * 0.5;
        double cost = baseCost - discount;
        System.out.println("Group Delivery: Distance " + distance + "km ($" + baseCost + ") - Group discount ($" + discount + ") = $" + cost);
        return cost;
    }
    
    // Festival special - distance + discount percentage + free delivery check
    public double calculateDelivery(double distance, double discountPercent, double orderAmount) {
        if (orderAmount >= 50.0) {
            System.out.println("Festival Special: FREE DELIVERY! Order amount $" + orderAmount + " qualifies for free delivery");
            return 0.0;
        }
        
        double baseCost = distance * 2.0;
        double discount = baseCost * (discountPercent / 100);
        double cost = baseCost - discount;
        System.out.println("Festival Special: Distance " + distance + "km ($" + baseCost + ") - Festival discount " + discountPercent + "% ($" + discount + ") = $" + cost);
        return cost;
    }
    
    public static void main(String[] args) {
        FoodDeliveryApp app = new FoodDeliveryApp();
        
        System.out.println("=== Food Delivery Charges ===\n");
        
        app.calculateDelivery(5.0);
        app.calculateDelivery(5.0, 3.0);
        app.calculateDelivery(5.0, 3);
        app.calculateDelivery(5.0, 20.0, 45.0);
        app.calculateDelivery(5.0, 20.0, 60.0);
    }
}