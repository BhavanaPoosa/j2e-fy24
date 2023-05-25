import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the values of the tree in pre-order traversal (comma-separated):");
        String input = scanner.nextLine();
        TreeNode root = buildTree(input);

        Solution solution = new Solution();
        boolean isBalanced = solution.isBalanced(root);
        System.out.println("Is the tree balanced? " + isBalanced);
    }

    private static TreeNode buildTree(String input) {

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
