package leecode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return false;

        List<Integer> result1 = new ArrayList<>();
        leaf(root1, result1);

        List<Integer> result2 = new ArrayList<>();
        leaf(root2, result2);

        return result1.equals(result2);
    }

    public void leaf(TreeNode node, List<Integer> result) {

        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        if (node.left != null)
            leaf(node.left, result);
        if (node.right != null)
            leaf(node.right, result);

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left =  new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);

        LeafSimilarTrees l = new LeafSimilarTrees();
        System.out.println(l.leafSimilar(root, root));
    }
}
