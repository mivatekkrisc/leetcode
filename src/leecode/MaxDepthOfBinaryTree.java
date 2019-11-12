package leecode;

import com.sun.source.tree.Tree;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return dept(root, 1);
    }

    public int dept(TreeNode n, int level) {
        if (n.left == null && n.right == null) return level;

        int right = n.right != null ? dept(n.right, level + 1) : level;
        int left = n.left != null ? dept(n.left, level + 1) : level;
        return Math.max(right, left);
    }

    public static void main(String args[]) {
        MaxDepthOfBinaryTree m = new MaxDepthOfBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(m.maxDepth(root));
    }
}
