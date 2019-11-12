package leecode;

import java.time.temporal.Temporal;

public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode pp = dfs(root, p);
        TreeNode pq = dfs(root, q);
        if(pp != pq) return root;
        else return lowestCommonAncestor(pp, p, q);
    }

    public TreeNode dfs(TreeNode parent, TreeNode node) {
        if(parent == null) return null;
        if(parent == node) return parent;

        if(dfs(parent.left, node) != null) return parent.left;
        if(dfs(parent.right, node) != null) return parent.right;

        return null;
    }

    public static void main(String args[]) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n0= new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);

        n3.left = n5;
        n3.right = n1;
        n5.left = n6;
        n5.right = n2;
        n2.left = n7;
        n2.right = n4;
        n1.left = n0;
        n1.right = n8;

        LowestCommonAncestorOfBinaryTree l = new LowestCommonAncestorOfBinaryTree();
        System.out.println(l.lowestCommonAncestor(n3, n4, n8).val);


    }


}
