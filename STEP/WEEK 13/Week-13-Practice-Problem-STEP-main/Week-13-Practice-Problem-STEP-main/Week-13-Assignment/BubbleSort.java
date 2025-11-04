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
    
    void bubbleSort() {
        if (head == null) return;
        
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
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

public class BubbleSort {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        
        // Create list [40 ⇄ 10 ⇄ 30 ⇄ 20]
        list.insert(40);
        list.insert(10);
        list.insert(30);
        list.insert(20);
        
        System.out.print("Original list: ");
        list.display();
        
        list.bubbleSort();
        System.out.print("After bubble sort: ");
        list.display();
    }
}