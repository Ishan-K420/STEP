import java.util.ArrayList;

public class StackImplementation {
    private ArrayList<Integer> stack;
    
    public StackImplementation() {
        stack = new ArrayList<>();
    }
    
    public void push(int item) {
        stack.add(item);
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    public int size() {
        return stack.size();
    }
    
    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation();
        
        System.out.println("Is empty: " + stack.isEmpty());
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Is empty: " + stack.isEmpty());
    }
}