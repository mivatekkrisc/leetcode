package leecode;

import com.sun.source.tree.Tree;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if(node == null) return true;

        if(lower != null && node.val <= lower) return false;
        if(upper != null && node.val >= upper) return false;

        if(!helper(node.left, lower, node.val)) return false;
        if(!helper(node.right, node.val, upper)) return false;

        return true;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new ValidBST().isValidBST(root));

        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(new ValidBST().isValidBST(root));

        root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(new ValidBST().isValidBST(root));

        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(new ValidBST().isValidBST(root));

    }

}
