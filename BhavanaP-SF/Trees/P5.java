import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the values of the first tree in pre-order traversal (comma-separated):");
        String input1 = scanner.nextLine();
        TreeNode root1 = buildTree(input1);

        System.out.println("Enter the values of the second tree in pre-order traversal (comma-separated):");
        String input2 = scanner.nextLine();
        TreeNode root2 = buildTree(input2);

        Solution solution = new Solution();
        TreeNode mergedTree = solution.mergeTrees(root1, root2);
        System.out.println("Merged Tree in pre-order traversal: ");
        printTree(mergedTree);
    }

    private static TreeNode buildTree(String input) {
        
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
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
