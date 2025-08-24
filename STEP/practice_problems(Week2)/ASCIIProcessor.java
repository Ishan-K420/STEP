import java.util.*;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Process each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;
            System.out.println("\nCharacter: " + ch + " | ASCII: " + ascii);

            String type = classifyCharacter(ch);
            System.out.println("Type: " + type);

            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.println("Upper: " + upper + " (" + (int) upper + ")");
                System.out.println("Lower: " + lower + " (" + (int) lower + ")");
                System.out.println("Difference: " + (int) Math.abs(upper - lower));
            }
        }

        // Show ASCII art from characters
        System.out.println("\nASCII Art:");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;
            System.out.print(ch + ": ");
            for (int j = 0; j < ascii % 20; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Caesar cipher example
        System.out.print("\nEnter shift value for Caesar Cipher: ");
        int shift = scanner.nextInt();
        String encrypted = caesarCipher(input, shift);
        System.out.println("Encrypted: " + encrypted);

        // ASCII table demo
        System.out.println("\nASCII Table (65–90):");
        displayASCIITable(65, 90);

        // String ↔ ASCII array conversion
        int[] asciiArr = stringToASCII(input);
        System.out.println("\nASCII Array: " + Arrays.toString(asciiArr));

        String convertedBack = asciiToString(asciiArr);
        System.out.println("Converted Back: " + convertedBack);

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') return "Uppercase Letter";
        else if (ch >= 'a' && ch <= 'z') return "Lowercase Letter";
        else if (ch >= '0' && ch <= '9') return "Digit";
        else return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') return (char) (ch + 32); // uppercase → lowercase
        else if (ch >= 'a' && ch <= 'z') return (char) (ch - 32); // lowercase → uppercase
        else return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                result.append((char) ((ch - 'A' + shift + 26) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ((ch - 'a' + shift + 26) % 26 + 'a'));
            } else {
                result.append(ch); // keep digits & specials unchanged
            }
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] arr = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = (int) text.charAt(i);
        }
        return arr;
    }

    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int val : asciiValues) {
            sb.append((char) val);
        }
        return sb.toString();
    }
}
