import java.util.Arrays;
import java.util.Scanner;

class Rotate {
    static int search(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;

        if (arr[l] <= arr[mid]) {
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            return search(arr, mid + 1, h, key);
        }

        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);

        return search(arr, l, mid - 1, key);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        String[] numbers = inputString.split(",");
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        int target = input.nextInt();

        int index = search(arr, 0, arr.length - 1, target);
        if (index != -1) {
            System.out.println( index);
        } else {
            System.out.println(-1);
        }
    }
}
