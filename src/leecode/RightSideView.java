package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class RightSideView {

    class Node {
        TreeNode n;
        int level;

        public Node(TreeNode node, int level) {
            this.n = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));
//        result.add(root.val);

        int level = 0;
        while(!queue.isEmpty()) {

            Node node = queue.poll();
            if(node.n.right != null)
                queue.offer(new Node(node.n.right, node.level+1));
            if(node.n.left != null)
                queue.offer(new Node(node.n.left, node.level+1));
            if(node.level != level) {
                result.add(node.n.val);
                level = node.level;
            }

        }

        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(new RightSideView().rightSideView(root).stream().map(i->String.valueOf(i)).collect(Collectors.joining(",")));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new RightSideView().rightSideView(root).stream().map(i->String.valueOf(i)).collect(Collectors.joining(",")));


    }
}
