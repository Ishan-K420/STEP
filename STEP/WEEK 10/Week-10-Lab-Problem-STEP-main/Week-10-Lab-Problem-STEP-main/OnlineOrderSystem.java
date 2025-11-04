class Customer {
    String name;
    String customerId;
    
    Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }
    
    void placeOrder(OrderService orderService, String item, double amount) {
        System.out.println(name + " placing order for " + item);
        orderService.createOrder(customerId, item, amount);
    }
}

class OrderService {
    void createOrder(String customerId, String item, double amount) {
        System.out.println("Order created for customer " + customerId);
        PaymentGateway payment = new PaymentGateway();
        boolean paymentSuccess = payment.processPayment(amount);
        
        if(paymentSuccess) {
            InventoryService inventory = new InventoryService();
            inventory.checkStock(item);
        }
    }
}

class PaymentGateway {
    boolean processPayment(double amount) {
        System.out.println("Processing payment of Rs." + amount);
        System.out.println("Payment successful");
        return true;
    }
}

class InventoryService {
    void checkStock(String item) {
        System.out.println("Checking stock for " + item);
        System.out.println("Item available, preparing for shipment");
    }
}

public class OnlineOrderSystem {
    public static void main(String[] args) {
        Customer customer = new Customer("Amit", "C001");
        OrderService orderService = new OrderService();
        
        customer.placeOrder(orderService, "Laptop", 45000.0);
    }
}
