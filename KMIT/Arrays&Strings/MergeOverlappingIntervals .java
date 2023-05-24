import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MergeOverlappingIntervals {
    public static void mergeIntervals(Interval arr[]) {
        if (arr.length <= 0)
            return;

        Arrays.sort(arr, (i1, i2) -> i1.start - i2.start);

        Stack<Interval> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            Interval top = stack.peek();

            if (top.end < arr[i].start)
                stack.push(arr[i]);
            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.print("[" + t.start + "," + t.end + "] ");
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Interval arr[] = new Interval[n];
        for (int i = 0; i < n; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            arr[i] = new Interval(start, end);
        }
        input.close();
        mergeIntervals(arr);
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
