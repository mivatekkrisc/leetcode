package leecode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfNaryTree {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class N {
        Node node;
        int level;

        public N(Node n, int level) {
            this.node = n;
            this.level = level;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;

        int level = 0;
        Queue<N> queue = new LinkedList<N>();
        queue.offer(new N(root, 1));

        while (!queue.isEmpty()) {
            N n = queue.poll();
            if (n.level != level)
                level = n.level;

            if (n.node.children != null)
                for (Node node : n.node.children)
                    queue.offer(new N(node, n.level + 1));
        }

        return level;
    }

    public static void main(String args[]) {
        Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3), n4 = new Node(4), n5 = new Node(5), n6 = new Node(6);
        n1.children = List.of(n3, n2, n4);
        n3.children = List.of(n5, n6);

        System.out.println(new MaximumDepthOfNaryTree().maxDepth(n1));


    }


}
