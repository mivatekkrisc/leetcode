package leecode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if(node == null) return;
        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = tmp;

        invert(node.left);
        invert(node.right);
    }

    public static void main(String args[]) {
        InvertBinaryTree i = new InvertBinaryTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root = i.invertTree(root);
        System.out.println(root);
    }
}
