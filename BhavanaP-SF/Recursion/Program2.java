import java.util.*;

class Program2 {
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;

        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int paths = uniquePaths(m, n);
        System.out.println("The number of unique paths in the grid is: " + paths);
    }
}
