class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;
    
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    boolean detectAndRemoveLoop() {
        if (head == null || head.next == null) return false;
        
        Node slow = head, fast = head;
        
        // Detect loop using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        
        if (fast == null || fast.next == null) return false;
        
        // Find start of loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Remove loop
        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
        
        return true;
    }
    
    void display() {
        Node current = head;
        int count = 0;
        while (current != null && count < 10) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" → ");
            current = current.next;
            count++;
        }
        System.out.println();
    }
    
    void createLoop(int position) {
        if (head == null) return;
        Node loopNode = head;
        for (int i = 1; i < position && loopNode != null; i++) {
            loopNode = loopNode.next;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = loopNode;
    }
}

public class DetectRemoveLoop {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Create list [10 → 20 → 30 → 40 → 50]
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        
        System.out.print("Original list: ");
        list.display();
        
        // Create loop: 50 points back to 30 (position 3)
        list.createLoop(3);
        System.out.println("Loop created: 50 points back to 30");
        
        if (list.detectAndRemoveLoop()) {
            System.out.println("Loop detected and removed");
            System.out.print("List after loop removal: ");
            list.display();
        } else {
            System.out.println("No loop found");
        }
    }
}