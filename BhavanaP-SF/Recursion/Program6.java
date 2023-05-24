import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Program6 {
    static void subsetSumsHelper(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset) {
        if (ind == N) {
            sumSubset.add(sum);
            return;
        }

        subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, N, sumSubset);

        subsetSumsHelper(ind + 1, sum, arr, N, sumSubset);
    }

    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        subsetSumsHelper(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the list: ");
        int N = scanner.nextInt();
        
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            arr.add(num);
        }
        scanner.close();

        ArrayList<Integer> result = subsetSums(arr, N);
        System.out.println("Subset Sums: " + result);
    }
}
