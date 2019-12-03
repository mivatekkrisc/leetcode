package leecode;

public class MergeTwoBinaryTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) return null;

        int val = 0;
        if (t1 != null) val += t1.val;
        if (t2 != null) val += t2.val;

        TreeNode root = new TreeNode(val);
        merge(t1 != null ? t1.left : null, t2 != null ? t2.left : null , root, true);
        merge(t1 != null ? t1.right : null, t2 != null ? t2.right : null , root, false);
        return root;
    }

    public void merge(TreeNode n1, TreeNode n2, TreeNode parent, boolean left) {

        if (n1 != null || n2 != null) {
            TreeNode node = new TreeNode(0);
            if (n1 != null) node.val += n1.val;
            if (n2 != null) node.val += n2.val;

            if (left)
                parent.left = node;
            else
                parent.right = node;

            merge(n1 != null ? n1.left : null, n2 != null ? n2.left: null, node, true);
            merge(n1 != null ? n1.right : null, n2 != null ? n2.right: null, node, false);

        }

    }

    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);

        TreeNode newTree = new MergeTwoBinaryTree().mergeTrees(null, t2);
        System.out.println("a");
    }
}
