class Node {
    int data;
    Node prev, next;
    
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class DoublyLinkedList {
    Node head, tail;
    
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    void deleteAll(int value) {
        Node current = head;
        
        while (current != null) {
            if (current.data == value) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = current.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }
    }
    
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" ⇄ ");
            current = current.next;
        }
        System.out.println();
    }
}

public class DeleteAllOccurrences {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        // Create list [10 ⇄ 20 ⇄ 30 ⇄ 20 ⇄ 40]
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(20);
        list.insert(40);
        
        System.out.print("Original list: ");
        list.display();
        
        list.deleteAll(20);
        System.out.print("After deleting all occurrences of 20: ");
        list.display();
    }
}