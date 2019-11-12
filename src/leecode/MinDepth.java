package leecode;

public class MinDepth {

    int min = 0;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        minDepth(root, 1);
        return min;
    }

    public void minDepth(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            if (min == 0 || level < min)
                min = level;
        }
        if(node.left != null) minDepth(node.left, level+1);
        if(node.right != null) minDepth(node.right, level+1);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MinDepth m = new MinDepth();
        System.out.println(m.minDepth(root));
    }
}
