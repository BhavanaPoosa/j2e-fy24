import java.util.Scanner;

class Program7 {
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
        else
            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                    knapSack(W, wt, val, n - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] wt = new int[n];
        int[] val = new int[n];

        System.out.println("Enter the weight and value of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight: ");
            wt[i] = scanner.nextInt();
            System.out.print("Item " + (i + 1) + " - Value: ");
            val[i] = scanner.nextInt();
        }

        System.out.print("Enter the maximum weight capacity: ");
        int W = scanner.nextInt();

        scanner.close();

        int maxValue = knapSack(W, wt, val, n);
        System.out.println("Maximum value: " + maxValue);
    }
}
