import java.util.ArrayList;
import java.util.Scanner;

public class program3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        ArrayList<Integer> result = Solution.max_of_subarrays(arr, size, k);

        System.out.println("Maximum elements of subarrays of size " + k + ":");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

class Solution {

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        int left = 0;
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = k - 1; i < arr.length; i++) {
            int ans = returnMax(arr, left, i);
            al.add(ans);
            left++;
        }
        return al;
    }

    static int returnMax(int[] arr, int startindex, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = startindex; i <= k; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }
}
