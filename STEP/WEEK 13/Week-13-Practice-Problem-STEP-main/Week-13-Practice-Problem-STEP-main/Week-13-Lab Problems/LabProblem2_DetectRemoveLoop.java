class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

class SinglyLinkedList {
    Node head;
    
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
    }
    
    boolean detectAndRemoveLoop() {
        if (head == null) return false;
        
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        
        if (fast == null || fast.next == null) return false;
        
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        while (fast.next != slow) fast = fast.next;
        fast.next = null;
        return true;
    }
    
    void createLoop(int position) {
        Node loopNode = head;
        for (int i = 1; i < position && loopNode != null; i++) {
            loopNode = loopNode.next;
        }
        
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = loopNode;
    }
    
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" → ");
            current = current.next;
        }
        System.out.println();
    }
}

public class LabProblem2_DetectRemoveLoop {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        
        System.out.print("Original list: ");
        list.display();
        
        list.createLoop(3);
        System.out.println("Loop created: 50 points back to 30");
        
        if (list.detectAndRemoveLoop()) {
            System.out.println("Loop detected and removed");
            System.out.print("List after loop removal: ");
            list.display();
        }
    }
}