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
    
    void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Invalid position");
            return;
        }
        
        newNode.next = current.next;
        current.next = newNode;
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

public class InsertAtPosition {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Create initial list [10 → 20 → 30 → 40]
        list.insertAtPosition(10, 1);
        list.insertAtPosition(20, 2);
        list.insertAtPosition(30, 3);
        list.insertAtPosition(40, 4);
        
        System.out.print("Initial list: ");
        list.display();
        
        // Insert 50 at position 3
        list.insertAtPosition(50, 3);
        System.out.print("After inserting 50 at position 3: ");
        list.display();
    }
}