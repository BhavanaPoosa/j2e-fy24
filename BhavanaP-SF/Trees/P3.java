import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the values of the tree in pre-order traversal (comma-separated):");
        String input = scanner.nextLine();
        TreeNode root = buildTree(input);

        Solution solution = new Solution();
        TreeNode invertedTree = solution.invertTree(root);
        System.out.println("Inverted tree in pre-order traversal:");
        printTreePreOrder(invertedTree);
    }

    private static TreeNode buildTree(String input) {
        String[] values = input.split(",");
        int n = values.length;
        if (n == 0 || values[0].equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && i < n) {
            TreeNode node = queue.poll();

            if (!values[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.left);
            }
            i++;

            if (i < n && !values[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }

    private static void printTreePreOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
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
