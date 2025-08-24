import java.util.*;

public class SimpleCSV {
    static String[][] parse(String text) {
        ArrayList<String[]> rows = new ArrayList<>();
        int start = 0;
        ArrayList<String> fields = new ArrayList<>();
        for (int i = 0; i <= text.length(); i++) {
            char c = (i < text.length()) ? text.charAt(i) : '\n';
            if (c == ',' || c == '\n') {
                fields.add(text.substring(start, i).trim());
                start = i + 1;
                if (c == '\n') {
                    rows.add(fields.toArray(new String[0]));
                    fields.clear();
                }
            }
        }
        return rows.toArray(new String[0][0]);
    }

    static void showTable(String[][] data) {
        for (String[] row : data) {
            for (String f : row) System.out.printf("%-12s", f);
            System.out.println();
        }
    }

    static void analyze(String[][] data) {
        for (int j = 0; j < data[0].length; j++) {
            boolean numeric = true;
            ArrayList<Integer> nums = new ArrayList<>();
            HashSet<String> uniq = new HashSet<>();
            for (int i = 1; i < data.length; i++) {
                String v = data[i][j];
                if (v.matches("\\d+")) nums.add(Integer.parseInt(v));
                else { numeric = false; uniq.add(v); }
            }
            if (numeric && !nums.isEmpty()) {
                int min = Collections.min(nums), max = Collections.max(nums);
                double avg = nums.stream().mapToInt(x->x).average().orElse(0);
                System.out.println("Column " + (j+1) + " -> Min: " + min + ", Max: " + max + ", Avg: " + avg);
            } else {
                System.out.println("Column " + (j+1) + " -> Unique: " + uniq);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CSV data (end with empty line):");
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            sb.append(line).append("\n");
        }
        String[][] data = parse(sb.toString());

        System.out.println("\nFormatted Table:");
        showTable(data);

        System.out.println("\nAnalysis:");
        analyze(data);

        System.out.println("\nSummary:");
        System.out.println("Rows: " + (data.length - 1));
        System.out.println("Columns: " + data[0].length);
    }
}