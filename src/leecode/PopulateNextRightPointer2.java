package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulateNextRightPointer2 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    static class C {
        Node n;
        int level;

        public C(Node n, int level) {
            this.n = n;
            this.level = level;
        }
    }

    public Node connect(Node root) {
        if (root == null) return root;

        Queue<C> queue = new LinkedList<>();
        queue.offer(new C(root, 1));

        List<C> nodes = new ArrayList();
        while (!queue.isEmpty()) {

            C c = queue.poll();
            if (c.n.left != null) {
                nodes.add(new C(c.n.left, c.level + 1));
                queue.offer(new C(c.n.left, c.level + 1));

            }
            if (c.n.right != null) {
                nodes.add(new C(c.n.right, c.level + 1));
                queue.offer(new C(c.n.right, c.level + 1));
            }
        }

        if (nodes.size() > 0) {

            int level = nodes.get(0).level;
            for (int i = 1; i < nodes.size(); i++) {
                if (nodes.get(i).level == level) {
                    nodes.get(i - 1).n.next = nodes.get(i).n;
                } else {
                    level = nodes.get(i).level;
                }
            }
        }
        return root;

    }
}
