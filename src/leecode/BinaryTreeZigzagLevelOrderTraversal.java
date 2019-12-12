package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean right = true;

        List<Integer> list = new ArrayList();

        while (!queue.isEmpty()) {

            TreeNode n = queue.poll();

            List<TreeNode> levelNodes = new ArrayList<>();
            while (n != null) {
                if (!right) list.add(0, n.val);
                else list.add(n.val);
                if (n.left != null) levelNodes.add(n.left);
                if (n.right != null) levelNodes.add(n.right);
                n = queue.poll();
            }
            result.add(list);
            list = new ArrayList<>();
            right = !right;

            for (TreeNode node : levelNodes)
                queue.offer(node);

        }
        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        for (List<Integer> list : new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root))
            System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
    }
}
