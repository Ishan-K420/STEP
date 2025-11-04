import java.util.Stack;

public class TextEditorUndo {
    private StringBuilder text;
    private Stack<String> undoStack;
    
    public TextEditorUndo() {
        this.text = new StringBuilder();
        this.undoStack = new Stack<>();
    }
    
    public void type(String newText) {
        undoStack.push(text.toString());
        text.append(newText);
        System.out.println("Typed: " + newText);
        display();
    }
    
    public void delete(int count) {
        undoStack.push(text.toString());
        int len = text.length();
        if (count > len) count = len;
        text.delete(len - count, len);
        System.out.println("Deleted " + count + " characters");
        display();
    }
    
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        text = new StringBuilder(undoStack.pop());
        System.out.println("Undo performed");
        display();
    }
    
    public void display() {
        System.out.println("Current text: \"" + text.toString() + "\"");
    }
    
    public static void main(String[] args) {
        TextEditorUndo editor = new TextEditorUndo();
        editor.type("Hello");
        editor.type(" World");
        editor.delete(3);
        editor.undo();
        editor.undo();
    }
}