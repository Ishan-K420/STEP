import java.util.*;

public class StringUtilityApp {
    // StringBuilder for efficient output
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== STRING UTILITY APPLICATION ===");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Text Analysis");
            System.out.println("2. String Transformation");
            System.out.println("3. ASCII Operations");
            System.out.println("4. Performance Testing");
            System.out.println("5. String Comparison Analysis");
            System.out.println("6. Custom String Algorithms");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text1 = scanner.nextLine();
                    performTextAnalysis(text1);
                    break;

                case 2:
                    System.out.print("Enter text: ");
                    String text2 = scanner.nextLine();
                    String[] operations = {"upper", "lower", "trim", "replace"};
                    System.out.println("Transformed: " + performTransformations(text2, operations));
                    break;

                case 3:
                    System.out.print("Enter text: ");
                    String text3 = scanner.nextLine();
                    performASCIIOperations(text3);
                    break;

                case 4:
                    System.out.print("Enter number of iterations: ");
                    int iters = scanner.nextInt();
                    performPerformanceTest(iters);
                    break;

                case 5:
                    System.out.print("Enter first string: ");
                    String s1 = scanner.nextLine();
                    System.out.print("Enter second string: ");
                    String s2 = scanner.nextLine();
                    performComparisonAnalysis(new String[]{s1, s2});
                    break;

                case 6:
                    System.out.print("Enter text: ");
                    String text6 = scanner.nextLine();
                    performCustomAlgorithms(text6);
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            displayResults();

        } while (choice != 0);

        scanner.close();
    }

    // 1. Text Analysis
    public static void performTextAnalysis(String text) {
        output.append("\n--- TEXT ANALYSIS ---\n");
        output.append("Length: ").append(text.length()).append("\n");

        String[] words = text.trim().split("\\s+");
        output.append("Word count: ").append(words.length).append("\n");

        // Character frequency
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        output.append("Character frequency: ").append(freq).append("\n");
    }

    // 2. String Transformations
    public static String performTransformations(String text, String[] operations) {
        StringBuilder sb = new StringBuilder(text);
        for (String op : operations) {
            switch (op.toLowerCase()) {
                case "upper": sb = new StringBuilder(sb.toString().toUpperCase()); break;
                case "lower": sb = new StringBuilder(sb.toString().toLowerCase()); break;
                case "trim": sb = new StringBuilder(sb.toString().trim()); break;
                case "replace": sb = new StringBuilder(sb.toString().replace("a", "@")); break;
            }
        }
        return sb.toString();
    }

    // 3. ASCII Operations
    public static void performASCIIOperations(String text) {
        output.append("\n--- ASCII OPERATIONS ---\n");
        for (char c : text.toCharArray()) {
            output.append(c).append(" : ").append((int) c).append("\n");
        }
    }

    // 4. Performance Testing
    public static void performPerformanceTest(int iterations) {
        output.append("\n--- PERFORMANCE TEST ---\n");

        long start, end;

        // String
        start = System.nanoTime();
        String s = "";
        for (int i = 0; i < iterations; i++) s += i;
        end = System.nanoTime();
        output.append("String time: ").append(end - start).append(" ns\n");

        // StringBuilder
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) sb.append(i);
        end = System.nanoTime();
        output.append("StringBuilder time: ").append(end - start).append(" ns\n");

        // StringBuffer
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) sbf.append(i);
        end = System.nanoTime();
        output.append("StringBuffer time: ").append(end - start).append(" ns\n");
    }

    // 5. String Comparison
    public static void performComparisonAnalysis(String[] strings) {
        String a = strings[0], b = strings[1];
        output.append("\n--- STRING COMPARISON ---\n");
        output.append("== : ").append(a == b).append("\n");
        output.append("equals: ").append(a.equals(b)).append("\n");
        output.append("equalsIgnoreCase: ").append(a.equalsIgnoreCase(b)).append("\n");
        output.append("compareTo: ").append(a.compareTo(b)).append("\n");
        output.append("compareToIgnoreCase: ").append(a.compareToIgnoreCase(b)).append("\n");
    }

    // 6. Custom Algorithms
    public static void performCustomAlgorithms(String text) {
        output.append("\n--- CUSTOM ALGORITHMS ---\n");
        String rev = new StringBuilder(text).reverse().toString();
        output.append("Palindrome: ").append(text.equalsIgnoreCase(rev)).append("\n");
    }

    // Display results
    public static void displayResults() {
        System.out.println(output.toString());
        output.setLength(0); // clear buffer
    }
}
