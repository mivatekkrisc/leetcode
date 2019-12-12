package leecode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diff = Math.abs(leftHeight-rightHeight);
        if(diff <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;

        return false;

    }

    public int height(TreeNode node) {

        if (node == null) return 0;
        return Math.max(height(node.left) + 1, height(node.right) + 1);

    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(new BalancedBinaryTree().isBalanced(root));

    }
}
