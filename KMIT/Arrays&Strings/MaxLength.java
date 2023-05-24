import java.util.*;

class MaxLength {
    public static int getMaxLength(int arr[], int n) {
        int count = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count = 0;
            else {
                count++;
                result = Math.max(result, count);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int a = arr.length;

        System.out.println(getMaxLength(arr, a));
    }
}
