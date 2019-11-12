package leecode;

import com.sun.source.tree.Tree;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        return dfs(root, sum);
    }

    public boolean dfs(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            if (sum == node.val)
                return true;
        }

        boolean result = false;
        if (node.left != null) {
            result = dfs(node.left, sum - node.val);
            if (result) return true;
        }
        if (node.right != null) {
            result = dfs(node.right, sum - node.val);
            if(result) return true;
        }

        return false;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(new PathSum().hasPathSum(root, 22));
    }
}
