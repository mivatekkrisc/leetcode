package leecode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {


    public int getMinimumDifference(TreeNode root) {

        if (root == null) return 0;

        List<Integer> values = new ArrayList<Integer>();
        inOrder(root, values);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < values.size(); i++)
            if (i - 1 >= 0 && values.get(i) - values.get(i - 1) < min)
                min = values.get(i) - values.get(i - 1);

        return min;
    }

    public void inOrder(TreeNode node, List<Integer> values) {

        if (node == null) return;

        if (node.left != null)
            inOrder(node.left, values);

        values.add(node.val);

        if (node.right != null)
            inOrder(node.right, values);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(root));
    }
}
