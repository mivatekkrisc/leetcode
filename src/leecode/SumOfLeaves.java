package leecode;

public class SumOfLeaves {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode node) {

        if (node == null) return;

        if (node.left != null && node.left.left == null && node.left.right == null)
            sum += node.left.val;

        if (node.left != null)
            dfs(node.left);
        if (node.right != null)
            dfs(node.right);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new SumOfLeaves().sumOfLeftLeaves(root));
    }
}
