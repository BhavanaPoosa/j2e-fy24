import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the values of the binary search tree nodes (space-separated):");
        String input = scanner.nextLine();
        String[] values = input.split(" ");

        System.out.println("Enter the value to search for:");
        int searchValue = scanner.nextInt();

        // Construct the binary search tree
        TreeNode root = constructBST(values, 0, values.length - 1);

        Solution solution = new Solution();
        TreeNode result = solution.searchBST(root, searchValue);

        if (result == null) {
            System.out.println("Node with value " + searchValue + " not found in the BST.");
        } else {
            System.out.println("Node with value " + searchValue + " found in the BST.");
        }
    }

    private static TreeNode constructBST(String[] values, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        int value = Integer.parseInt(values[mid]);

        TreeNode node = new TreeNode(value);
        node.left = constructBST(values, start, mid - 1);
        node.right = constructBST(values, mid + 1, end);

        return node;
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
