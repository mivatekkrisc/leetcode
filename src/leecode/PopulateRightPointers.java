package leecode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulateRightPointers {

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
            if (c.n.left != null && c.n.right != null) {
                nodes.add(new C(c.n.left, c.level + 1));
                nodes.add(new C(c.n.right, c.level + 1));

                queue.offer(new C(c.n.left, c.level + 1));
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

    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        PopulateRightPointers p = new PopulateRightPointers();
        n1 = p.connect(n1);
        System.out.println(n1);
    }
}
