package leecode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Queue;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;
        else if(p != null && q != null)
            return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        else
            return false;

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree s = new SymmetricTree();
        System.out.println(s.isSymmetric(root));

    }
}
