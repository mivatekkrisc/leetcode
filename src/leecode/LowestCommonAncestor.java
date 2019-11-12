package leecode;

import com.sun.source.tree.Tree;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode parent, TreeNode p, TreeNode q) {
        System.out.println(String.format("%s %s %s", parent != null ? parent.val : parent, p.val, q.val ));


        if(parent == p || p.right == q || p.left == q) return p;
        if(parent == q || q.left == p || q.right == p) return q;
        if(p.val < parent.val && q.val > parent.val) return parent;
        if(p.val > parent.val && q.val < parent.val) return parent;
        if(p.val < parent.val && q.val < parent.val) return dfs(parent.left, p, q);
        else return dfs(parent.right, p, q);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);

        root.left = n2;
        n2.left = n0;
        n2.right = n4;
        n4.left = n3;
        n4.right = n5;
        root.right = n8;
        n8.left = n7;
        n8.right = n9;

        LowestCommonAncestor l = new LowestCommonAncestor();
//        System.out.println(l.lowestCommonAncestor(root, n2, n8).val);
//        System.out.println(l.lowestCommonAncestor(root, n2, n4).val);
//        System.out.println(l.lowestCommonAncestor(root, n5, n9).val);


        root = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        n3 = new TreeNode(3);
        root.left = n1;
        root.right = n3;
//        System.out.println(l.lowestCommonAncestor(root, n3, n1).val);

        root = new TreeNode(3);
        n1 = new TreeNode(1);
        n4 = new TreeNode(4);
        n2 = new TreeNode(2);
        root.left = n1;
        root.right = n4;
        n1.right = n2;
        System.out.println(l.lowestCommonAncestor(root, n2, root).val);
    }



}
