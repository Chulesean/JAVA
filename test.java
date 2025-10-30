import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pattern = sc.nextLine();
        String text = sc.nextLine();

        if (pattern.isEmpty()) return;

        posDirect(pattern, text);
    }

    public static void posDirect(String pattern, String text) {
        int p = pattern.length();
        int n = text.length();

        if (p > n) {
            return;
        }

        int[] prefix = preFix(pattern);
        int j = 0;
        boolean first = true;

        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefix[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            if (j == p) {
                if (!first) System.out.print(" ");
                System.out.print(i - p + 1);
                first = false;
                j = prefix[j - 1];
            }
        }
    }

    public static int[] preFix(String pattern) {
        int p = pattern.length();
        int[] prefix = new int[p];
        int len = 0;

        for (int i = 1; i < p; i++) {
            while (len > 0 && pattern.charAt(i) != pattern.charAt(len)) {
                len = prefix[len - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
            }

            prefix[i] = len;
        }

        return prefix;
    }
}