import java.util.*;

public class SpellChecker {
    static String[] splitWords(String s) {
        ArrayList<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                if (i == s.length() - 1) i++;
                list.add(s.substring(start, i));
                start = i + 1;
            }
        }
        return list.toArray(new String[0]);
    }

    static int distance(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = (a.charAt(i - 1) == b.charAt(j - 1)) ? dp[i - 1][j - 1]
                        : 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        return dp[n][m];
    }

    static String closest(String w, String[] dict) {
        String best = w;
        int min = 99;
        for (String d : dict) {
            int dist = distance(w.toLowerCase(), d.toLowerCase());
            if (dist < min) {
                min = dist;
                best = d;
            }
        }
        return (min <= 2) ? best : w;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dict = {"hello", "world", "java", "code", "simple", "spell", "check"};
        System.out.println("Enter a sentence:");
        String[] words = splitWords(sc.nextLine());
        System.out.printf("%-12s %-12s %-8s %-12s\n", "Word", "Suggestion", "Dist", "Status");
        for (String w : words) {
            String sug = closest(w, dict);
            int d = distance(w, sug);
            String status = (d == 0) ? "Correct" : "Misspelled";
            System.out.printf("%-12s %-12s %-8d %-12s\n", w, sug, d, status);
        }
    }
}
