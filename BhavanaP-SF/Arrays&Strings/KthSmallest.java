import java.util.Scanner;

class KthSmallest {
    public static int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            } else if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1; // Kth largest element not found
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] >= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        String[] numbers = inputString.split(",");
        int[] nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }

        int k = input.nextInt();

        int kthLargest = findKthLargest(nums, k);
        System.out.println("Output: " + kthLargest);
    }
}
