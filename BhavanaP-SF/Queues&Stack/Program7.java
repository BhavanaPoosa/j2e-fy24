import java.util.Stack;
import java.util.Scanner;

public class program7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        long[] arr = new long[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        Solution solution = new Solution();
        long[] result = solution.nextLargerElement(arr, n);

        System.out.println("Next larger elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

class Solution {
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] r = new long[n];
        r[n - 1] = -1;
        Stack<Long> s = new Stack<>();
        s.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            long v = arr[i];

            while (!s.isEmpty() && v >= s.peek()) {
                s.pop();
            }

            if (s.isEmpty()) {
                r[i] = -1;
            } else {
                r[i] = s.peek();
            }

            s.push(v);
        }

        return r;
    }
}
