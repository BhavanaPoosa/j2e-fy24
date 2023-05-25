import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the values of the first tree in pre-order traversal (comma-separated):");
        String input1 = scanner.nextLine();
        TreeNode p = buildTree(input1);

        System.out.println("Enter the values of the second tree in pre-order traversal (comma-separated):");
        String input2 = scanner.nextLine();
        TreeNode q = buildTree(input2);

        Solution solution = new Solution();
        boolean isSame = solution.isSameTree(p, q);
        System.out.println("Are the two trees same? " + isSame);
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
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
