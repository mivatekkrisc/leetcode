package leecode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p != null && q != null) {
            if (p.val != q.val) return false;

            boolean leftSame = isSameTree(p.left, q.left);
            if(!leftSame) return false;

            boolean rightSame = isSameTree(p.right, q.right);
            if(!rightSame) return false;

            return true;
        } else {
            return false;
        }

    }

    public static void main(String args[]) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        SameTree s = new SameTree();
        System.out.println(s.isSameTree(root1, root2));
    }
}
