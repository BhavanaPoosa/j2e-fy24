import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class program5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();

        Solution solution = new Solution();
        ArrayList<Integer> result = solution.rotation(N);

        System.out.println("Result: " + result);
    }
}

class Solution {
    ArrayList<Integer> rotation(int N) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] arr = new int[1001];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int i = 1;
        while (!q.isEmpty()) {
            int j = 0;
            while (j < i) {
                int x = q.peek();
                q.poll();
                q.add(x);
                j++;
            }
            int x = q.peek();
            if (arr[x] != 0) {
                res.add(-1);
                return res;
            }
            arr[x] = i;
            q.poll();
            i++;
        }

        for (i = 1; i <= N; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
