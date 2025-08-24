import java.util.*;

public class PasswordTool {
    static int[] analyze(String p) {
        int up = 0, low = 0, dig = 0, sp = 0;
        for (int i = 0; i < p.length(); i++) {
            int ch = p.charAt(i);
            if (ch >= 65 && ch <= 90) up++;
            else if (ch >= 97 && ch <= 122) low++;
            else if (ch >= 48 && ch <= 57) dig++;
            else sp++;
        }
        return new int[]{up, low, dig, sp};
    }

    static int score(String p) {
        int[] a = analyze(p);
        int s = 0;
        if (p.length() > 8) s += (p.length() - 8) * 2;
        if (a[0] > 0) s += 10;
        if (a[1] > 0) s += 10;
        if (a[2] > 0) s += 10;
        if (a[3] > 0) s += 10;
        String[] bad = {"123", "abc", "qwerty"};
        for (String b : bad) if (p.toLowerCase().contains(b)) s -= 10;
        return s;
    }

    static String level(int s) {
        if (s <= 20) return "Weak";
        if (s <= 50) return "Medium";
        return "Strong";
    }

    static String generate(int len) {
        String up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String low = "abcdefghijklmnopqrstuvwxyz";
        String dig = "0123456789";
        String sp = "!@#$%^&*()_+";
        String all = up + low + dig + sp;
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(up.charAt(r.nextInt(up.length())));
        sb.append(low.charAt(r.nextInt(low.length())));
        sb.append(dig.charAt(r.nextInt(dig.length())));
        sb.append(sp.charAt(r.nextInt(sp.length())));
        for (int i = 4; i < len; i++) sb.append(all.charAt(r.nextInt(all.length())));
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) chars.add(sb.charAt(i));
        Collections.shuffle(chars);
        StringBuilder res = new StringBuilder();
        for (char c : chars) res.append(c);
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of passwords to analyze:");
        int n = sc.nextInt();
        sc.nextLine();
        String[] pwds = new String[n];
        for (int i = 0; i < n; i++) pwds[i] = sc.nextLine();
        System.out.printf("%-12s %-6s %-6s %-6s %-6s %-6s %-6s %-8s\n",
                "Password", "Len", "Up", "Low", "Dig", "Spec", "Score", "Level");
        for (String p : pwds) {
            int[] a = analyze(p);
            int s = score(p);
            System.out.printf("%-12s %-6d %-6d %-6d %-6d %-6d %-6d %-8s\n",
                    p, p.length(), a[0], a[1], a[2], a[3], s, level(s));
        }
        System.out.println("Enter length for new strong password:");
        int len = sc.nextInt();
        System.out.println("Generated: " + generate(len));
    }
}