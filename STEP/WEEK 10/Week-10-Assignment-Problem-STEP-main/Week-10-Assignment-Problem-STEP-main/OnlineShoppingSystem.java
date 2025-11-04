class Customer {
    String name;
    String customerId;
    
    Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }
    
    void browseProducts(Cart cart, String item, double price) {
        System.out.println(name + " browsing products...");
        cart.addItem(item, price);
    }
    
    void checkout(Cart cart, PaymentService paymentService, OrderService orderService) {
        double total = cart.calculateTotal();
        boolean paid = paymentService.makePayment(total);
        if(paid) {
            orderService.confirmOrder(customerId);
        }
    }
}

class Cart {
    String[] items;
    double[] prices;
    int itemCount;
    
    Cart() {
        items = new String[10];
        prices = new double[10];
        itemCount = 0;
    }
    
    void addItem(String item, double price) {
        items[itemCount] = item;
        prices[itemCount] = price;
        itemCount++;
        System.out.println("Added " + item + " to cart - Rs." + price);
    }
    
    double calculateTotal() {
        double total = 0;
        for(int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        System.out.println("Cart total: Rs." + total);
        return total;
    }
}

class PaymentService {
    boolean makePayment(double amount) {
        System.out.println("Processing payment of Rs." + amount);
        System.out.println("Payment successful");
        return true;
    }
}

class OrderService {
    void confirmOrder(String customerId) {
        System.out.println("Order confirmed for customer " + customerId);
        System.out.println("Order ID: ORD" + (int)(Math.random() * 1000));
    }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Customer customer = new Customer("Neha", "CUST001");
        Cart cart = new Cart();
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService();
        
        customer.browseProducts(cart, "Laptop", 45000);
        customer.browseProducts(cart, "Mouse", 500);
        customer.checkout(cart, paymentService, orderService);
    }
}
