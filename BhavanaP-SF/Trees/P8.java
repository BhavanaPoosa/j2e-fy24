import java.util.Scanner;

public class P8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the sorted array elements (space-separated):");
        String input = scanner.nextLine();
        String[] numsString = input.split(" ");
        int[] nums = new int[numsString.length];
        for (int i = 0; i < numsString.length; i++) {
            nums[i] = Integer.parseInt(numsString[i]);
        }

        Solution solution = new Solution();
        TreeNode root = solution.sortedArrayToBST(nums);

        System.out.println("The constructed BST is:");
        printTree(root);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

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
