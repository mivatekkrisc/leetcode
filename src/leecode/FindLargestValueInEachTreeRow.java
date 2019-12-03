package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class FindLargestValueInEachTreeRow {

    class Node {
        TreeNode n;
        int level;

        public Node(TreeNode n, int level) {
            this.n = n;
            this.level = level;
        }
    }

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 1));

        int level = 0;
        Integer maxValue = null;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            while (node != null) {
                if (node.level != level) {
                    if (maxValue != null)
                        result.add(maxValue);

                    level = node.level;
                    maxValue = node.n.val;


                } else {
                    if (node.n.val > maxValue)
                        maxValue = node.n.val;
                }
                if (node.n.left != null)
                    queue.offer(new Node(node.n.left, node.level + 1));
                if (node.n.right != null)
                    queue.offer(new Node(node.n.right, node.level + 1));
                node = queue.poll();
            }
        }
        if(maxValue != null)
            result.add(maxValue);

        return result;

    }

    public static void main(String args[]) {
        FindLargestValueInEachTreeRow f = new FindLargestValueInEachTreeRow();
        TreeNode root = new TreeNode(1);
        System.out.println(f.largestValues(root).stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(f.largestValues(root).stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

    }
}
