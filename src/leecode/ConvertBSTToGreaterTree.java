package leecode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;

        List<TreeNode> nodes = new ArrayList<TreeNode>();


        inOrder(root, nodes);
        for (int i = nodes.size() - 2; i >= 0; i--) {
            nodes.get(i).val = nodes.get(i).val + nodes.get(i + 1).val;
        }
        return root;
    }

    public void inOrder(TreeNode node, List<TreeNode> nodes) {
        if (node == null) return;

        if (node.left != null)
            inOrder(node.left, nodes);
        nodes.add(node);
        if (node.right != null)
            inOrder(node.right, nodes);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        new ConvertBSTToGreaterTree().convertBST(root);
        System.out.println("a");
    }
}
