package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    static class Node {
        TreeNode node;
        int level;

        public Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<Double>();
        if(root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));

        int level = 0;
        long sum = 0, count = 0;
        while (!queue.isEmpty()) {

            Node n = queue.poll();

            if (level != n.level) {
                if(count > 0)
                    result.add(Double.valueOf(sum / (double) count));
                sum = n.node.val;
                count = 1;
                level = n.level;
            } else {
                sum += n.node.val;
                count++;
            }
            if (n.node.left != null)
                queue.offer(new Node(n.node.left, n.level + 1));
            if (n.node.right != null)
                queue.offer(new Node(n.node.right, n.level + 1));

        }
        result.add(Double.valueOf(sum / (double) count));
        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        for (Double d : new AverageOfLevelsInBinaryTree().averageOfLevels(root))
            System.out.println(d);
    }
}
