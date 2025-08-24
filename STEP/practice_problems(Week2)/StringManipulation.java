import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence with mixed formatting: ");
        String input = scanner.nextLine();

        // 1. trim()
        String trimmed = input.trim();
        System.out.println("1. Trimmed: " + trimmed);

        // 2. replace() - replace spaces with underscores
        String replaced = trimmed.replace(" ", "_");
        System.out.println("2. Spaces replaced: " + replaced);

        // 3. replaceAll() - remove digits
        String noDigits = trimmed.replaceAll("\\d", "");
        System.out.println("3. Digits removed: " + noDigits);

        // 4. split() - split into words
        String[] words = trimmed.split("\\s+");
        System.out.println("4. Words: " + Arrays.toString(words));

        // 5. join() - rejoin with separator
        String joined = String.join(" | ", words);
        System.out.println("5. Joined: " + joined);

        // Extra processing
        String noPunc = removePunctuation(trimmed);
        System.out.println("6. No punctuation: " + noPunc);

        String capitalized = capitalizeWords(trimmed);
        System.out.println("7. Capitalized: " + capitalized);

        String reversedOrder = reverseWordOrder(trimmed);
        System.out.println("8. Reversed order: " + reversedOrder);

        System.out.println("9. Word Frequency: ");
        countWordFrequency(trimmed);

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String w : words) {
            if (w.length() > 0) {
                result.append(Character.toUpperCase(w.charAt(0)))
                      .append(w.substring(1).toLowerCase())
                      .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            w = w.replaceAll("\\p{Punct}", "");
            if (w.isEmpty()) continue;
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
