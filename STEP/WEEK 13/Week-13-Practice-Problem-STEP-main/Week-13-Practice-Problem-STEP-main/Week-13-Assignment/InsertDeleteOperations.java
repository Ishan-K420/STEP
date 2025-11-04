class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node tail;
    
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }
    
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    void deleteAtBeginning() {
        if (tail == null) return;
        
        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
    }
    
    void deleteAtEnd() {
        if (tail == null) return;
        
        if (tail.next == tail) {
            tail = null;
        } else {
            Node current = tail.next;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
    }
    
    void display() {
        if (tail == null) {
            System.out.println("Empty list");
            return;
        }
        
        Node current = tail.next;
        do {
            System.out.print(current.data);
            current = current.next;
            if (current != tail.next) System.out.print(" → ");
        } while (current != tail.next);
        System.out.println(" → back to " + tail.next.data);
    }
}

public class InsertDeleteOperations {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        
        // Insert 10, 20, 30
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.print("After inserting 10, 20, 30: ");
        list.display();
        
        // Delete first
        list.deleteAtBeginning();
        System.out.print("After deleting first: ");
        list.display();
        
        // Insert 40 at end
        list.insertAtEnd(40);
        System.out.print("After inserting 40 at end: ");
        list.display();
    }
}