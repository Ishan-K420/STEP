import java.util.LinkedList;
import java.util.Queue;

public class CustomerServiceQueue {
    private Queue<String> customerQueue;
    
    public CustomerServiceQueue() {
        this.customerQueue = new LinkedList<>();
    }
    
    public void addCustomer(String customer) {
        customerQueue.offer(customer);
        System.out.println("Customer " + customer + " added to queue");
        displayQueue();
    }
    
    public void serveCustomer() {
        if (customerQueue.isEmpty()) {
            System.out.println("No customers to serve");
            return;
        }
        String customer = customerQueue.poll();
        System.out.println("Serving customer: " + customer);
        displayQueue();
    }
    
    public void displayQueue() {
        if (customerQueue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Current queue: " + customerQueue);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        CustomerServiceQueue service = new CustomerServiceQueue();
        
        service.addCustomer("Alice");
        service.addCustomer("Bob");
        service.addCustomer("Charlie");
        service.serveCustomer();
        service.serveCustomer();
        service.addCustomer("David");
        service.serveCustomer();
        service.serveCustomer();
        service.serveCustomer();
    }
}