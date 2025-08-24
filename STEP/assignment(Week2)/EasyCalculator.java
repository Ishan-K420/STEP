import java.util.*;

public class EasyCalculator {
    static int evalFlat(String exp) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        int i = 0;
        while (i < exp.length()) {
            char c = exp.charAt(i);
            if (c == ' ') { i++; continue; }
            if (Character.isDigit(c)) {
                int j = i;
                while (j < exp.length() && Character.isDigit(exp.charAt(j))) j++;
                nums.add(Integer.parseInt(exp.substring(i, j)));
                i = j;
            } else {
                ops.add(c);
                i++;
            }
        }
        for (int k = 0; k < ops.size();) {
            char op = ops.get(k);
            if (op == '*' || op == '/') {
                int a = nums.get(k), b = nums.get(k+1);
                int r = (op == '*') ? a*b : a/b;
                nums.set(k, r);
                nums.remove(k+1);
                ops.remove(k);
            } else k++;
        }
        while (!ops.isEmpty()) {
            char op = ops.remove(0);
            int a = nums.remove(0), b = nums.remove(0);
            int r = (op == '+') ? a+b : a-b;
            nums.add(0, r);
        }
        return nums.get(0);
    }

    static int eval(String exp) {
        while (exp.contains("(")) {
            int l = exp.lastIndexOf("(");
            int r = exp.indexOf(")", l);
            int val = evalFlat(exp.substring(l+1, r));
            exp = exp.substring(0, l) + val + exp.substring(r+1);
        }
        return evalFlat(exp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression:");
        String expr = sc.nextLine();
        int result = eval(expr);
        System.out.println("Result: " + result);
    }
}