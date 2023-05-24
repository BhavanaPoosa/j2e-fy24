import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Program5 {
    public static List<List<Integer>> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTreesHelper(1, n);
    }

    public static List<List<Integer>> generateTreesHelper(int start, int end) {
        List<List<Integer>> trees = new ArrayList<>();
        if (start > end) {
            trees.add(new ArrayList<>());
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<List<Integer>> leftSubtrees = generateTreesHelper(start, i - 1);
            List<List<Integer>> rightSubtrees = generateTreesHelper(i + 1, end);
            for (List<Integer> left : leftSubtrees) {
                for (List<Integer> right : rightSubtrees) {
                    List<Integer> tree = new ArrayList<>();
                    tree.add(0);
                    tree.addAll(left);
                    tree.add(0);
                    tree.addAll(right);
                    trees.add(tree);
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        scanner.close();

        List<List<Integer>> result = generateTrees(n);
        System.out.println("Output:");
        System.out.println(result);
    }
}
