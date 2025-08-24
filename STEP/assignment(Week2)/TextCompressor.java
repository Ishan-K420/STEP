import java.util.*;

public class TextCompressor {
    static char[] chars;
    static int[] freq;

    static void countFreq(String text) {
        chars = new char[text.length()];
        freq = new int[text.length()];
        int n = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int pos = -1;
            for (int j = 0; j < n; j++) if (chars[j] == c) pos = j;
            if (pos == -1) {
                chars[n] = c;
                freq[n] = 1;
                n++;
            } else freq[pos]++;
        }
        chars = Arrays.copyOf(chars, n);
        freq = Arrays.copyOf(freq, n);
    }

    static String[][] buildCodes() {
        String[][] map = new String[chars.length][2];
        for (int i = 0; i < chars.length; i++) {
            map[i][0] = String.valueOf(chars[i]);
            map[i][1] = Integer.toString(i, chars.length + 1); 
        }
        return map;
    }

    static String compress(String text, String[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (String[] m : map) if (m[0].charAt(0) == c) sb.append(m[1]);
        }
        return sb.toString();
    }

    static String decompress(String comp, String[][] map) {
        StringBuilder sb = new StringBuilder();
        int base = chars.length + 1;
        for (int i = 0; i < comp.length(); i++) {
            String code = String.valueOf(comp.charAt(i));
            for (String[] m : map) if (m[1].equals(code)) sb.append(m[0]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = sc.nextLine();

        countFreq(text);
        String[][] map = buildCodes();
        String comp = compress(text, map);
        String decomp = decompress(comp, map);

        System.out.println("\nCharacter Frequency:");
        for (int i = 0; i < chars.length; i++)
            System.out.println(chars[i] + " : " + freq[i]);

        System.out.println("\nCompression Mapping:");
        for (String[] m : map) System.out.println(m[0] + " -> " + m[1]);

        System.out.println("\nOriginal: " + text);
        System.out.println("Compressed: " + comp);
        System.out.println("Decompressed: " + decomp);

        double ratio = (double) comp.length() / text.length() * 100;
        System.out.println("\nCompression Efficiency: " + (100 - ratio) + "%");
    }
}