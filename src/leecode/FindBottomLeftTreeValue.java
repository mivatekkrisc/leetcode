package leecode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    class Node {
        TreeNode node;
        int level;

        public Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int findBottomLeftValue(TreeNode root) {

        if (root == null) return -1;

        int result = -1, level = 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 1));

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            while (node != null) {

                if (node.level != level) {
                    level = node.level;
                    result = node.node.val;
                }
                if (node.node.left != null)
                    queue.offer(new Node(node.node.left, node.level + 1));
                if (node.node.right != null)
                    queue.offer(new Node(node.node.right, node.level + 1));

                node = queue.poll();
            }
        }
        return result;
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);

        System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue(root));
    }
}
