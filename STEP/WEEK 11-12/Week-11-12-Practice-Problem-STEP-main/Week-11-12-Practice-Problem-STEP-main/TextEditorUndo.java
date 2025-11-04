import java.util.*;

public class TextEditorUndo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter command (TYPE <word>/UNDO/PRINT/EXIT): ");
            String cmd = sc.next();
            
            if (cmd.equals("TYPE")) {
                stack.push(sc.next());
            } else if (cmd.equals("UNDO")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (cmd.equals("PRINT")) {
                System.out.println(String.join(" ", stack));
            } else if (cmd.equals("EXIT")) {
                break;
            }
        }
        sc.close();
    }
}