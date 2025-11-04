import java.util.Stack;

public class ReverseString {
    public static String reverseUsingStack(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }
    
    public static void main(String[] args) {
        String input = "HELLO";
        String output = reverseUsingStack(input);
        System.out.println("Input: " + input + " → Output: " + output);
    }
}