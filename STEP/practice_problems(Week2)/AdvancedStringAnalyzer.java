import java.util.Scanner;

public class AdvancedStringAnalyzer{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ADVANCED STRING ANALYZER ===");
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        // Perform comparison analysis
        performAllComparisons(str1, str2);

        // Similarity percentage
        double similarity = calculateSimilarity(str1, str2);
        System.out.println("Similarity Percentage: " + similarity + "%");

        // Memory usage analysis
        analyzeMemoryUsage(str1, str2);

        // Optimized string processing example
        String[] inputs = {"Java", "is", "fast", "and", "efficient!"};
        String processed = optimizedStringProcessing(inputs);
        System.out.println("Optimized String Processing: " + processed);

        // Demonstrate string pool with intern()
        demonstrateStringIntern();

        scanner.close();
    }

    // Method to calculate similarity using Levenshtein Distance
    public static double calculateSimilarity(String str1, String str2) {
        int distance = levenshteinDistance(str1, str2);
        int maxLength = Math.max(str1.length(), str2.length());
        if (maxLength == 0) return 100.0; // both empty
        return ((1 - (double) distance / maxLength) * 100);
    }

    // Levenshtein Distance implementation
    private static int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= s2.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1],
                        Math.min(dp[i - 1][j], dp[i][j - 1])
                    );
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // Method to perform all comparisons
    public static void performAllComparisons(String str1, String str2) {
        System.out.println("\n=== COMPARISON RESULTS ===");
        System.out.println("Reference equality (==): " + (str1 == str2));
        System.out.println("Content equality (equals): " + str1.equals(str2));
        System.out.println("Case-insensitive equality: " + str1.equalsIgnoreCase(str2));
        System.out.println("Lexicographic comparison (compareTo): " + str1.compareTo(str2));
        System.out.println("Case-insensitive compareTo: " + str1.compareToIgnoreCase(str2));
    }

    // Method to analyze memory usage (approximation)
    public static void analyzeMemoryUsage(String... strings) {
        System.out.println("\n=== MEMORY USAGE ANALYSIS ===");
        for (String s : strings) {
            int approxMemory = 40 + (2 * s.length()); // approx size in bytes
            System.out.println("String: \"" + s + "\" | Approx. memory: " + approxMemory + " bytes");
        }
    }

    // Method to optimize string processing
    public static String optimizedStringProcessing(String[] inputs) {
        StringBuilder sb = new StringBuilder();
        for (String word : inputs) {
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }

    // Demonstrate intern() method
    public static void demonstrateStringIntern() {
        System.out.println("\n=== STRING INTERN DEMONSTRATION ===");
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println("Before intern: s1==s2 ? " + (s1 == s2));
        s1 = s1.intern();
        s2 = s2.intern();
        System.out.println("After intern: s1==s2 ? " + (s1 == s2));
    }
}
