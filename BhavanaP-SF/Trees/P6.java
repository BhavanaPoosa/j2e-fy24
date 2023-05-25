import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the values of the tree nodes in in-order traversal (comma-separated):");
        String input = scanner.nextLine();
        TreeNode root = buildTree(input);

        Solution solution = new Solution();
        boolean isValid = solution.isValidBST(root);

        System.out.println("Is the given tree a valid binary search tree? " + isValid);
    }

    private static TreeNode buildTree(String input) {
        String[] values = input.split(",");
        List<Integer> inorder = new ArrayList<>();
        for (String value : values) {
            inorder.add(Integer.parseInt(value.trim()));
        }
        return buildTreeFromInorder(inorder, 0, inorder.size() - 1);
    }

    private static TreeNode buildTreeFromInorder(List<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = buildTreeFromInorder(inorder, start, mid - 1);
        root.right = buildTreeFromInorder(inorder, mid + 1, end);
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
