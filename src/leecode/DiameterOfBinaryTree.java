package leecode;

public class DiameterOfBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = 0, rightDepth = 0;
        if (root.left != null)
            leftDepth = depth(root.left, 1);
        if (root.right != null)
            rightDepth = depth(root.right, 1);

        if (leftDepth + rightDepth > diameter)
            diameter = leftDepth + rightDepth;

        if (root.left != null)
            diameterOfBinaryTree(root.left);
        if (root.right != null)
            diameterOfBinaryTree(root.right);

        return diameter;

    }

    private int depth(TreeNode node, int depth) {
        if (node == null) return depth;
        if (node.left == null && node.right == null) return depth;

        return Math.max(depth(node.left, depth + 1), depth(node.right, depth + 1));
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }
}
