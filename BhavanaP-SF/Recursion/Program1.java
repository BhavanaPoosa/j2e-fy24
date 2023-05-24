import java.util.*;

class Program1 {
    public static void printStrings(char[] set, int k) {
        int n = set.length;
        printStringsUtil(set, "", n, k);
    }

    private static void printStringsUtil(char[] set, String prefix, int n, int k) {
        if (k == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < n; i++) {
            String newPrefix = prefix + set[i];
            printStringsUtil(set, newPrefix, n, k - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] set = new char[n];

        for (int i = 0; i < n; i++) {
            set[i] = scanner.next().charAt(0);
        }
        int k = scanner.nextInt();

        printStrings(set, k);
    }
}
