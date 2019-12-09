package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class NaryTreeLevelOrderTraversal {

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

    ;

    class N {
        Node node;
        int level;

        public N(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<N> queue = new LinkedList<>();
        queue.offer(new N(root, 1));

        int level = 1;
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            N n = queue.poll();

            if (level == n.level)
                tmp.add(n.node.val);
            else {
                result.add(tmp);
                tmp = new ArrayList<>();
                tmp.add(n.node.val);
                level = n.level;
            }

            if (n.node.children != null)
                for (Node child : n.node.children)
                    queue.offer(new N(child, n.level + 1));

        }
        if (tmp.size() > 0)
            result.add(tmp);
        return result;
    }

    public static void main(String args[]) {
        Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3), n4 = new Node(4), n5 = new Node(5), n6 = new Node(6);
        Node n7 = new Node(7), n8 = new Node(8), n9 = new Node(9), n10 = new Node(10), n11 = new Node(11), n12 = new Node(12),
                n13 = new Node(13), n14 = new Node(14);
//        n1.children = List.of(n3, n2, n4);
//        n3.children = List.of(n5, n6);
        n1.children = List.of(n2,n3,n4,n5);
        n3.children = List.of(n6,n7);
        n7.children = List.of(n11);
        n11.children = List.of(n14);
        n4.children = List.of(n8);
        n8.children = List.of(n12);
        n5.children = List.of(n9, n10);
        n9.children = List.of(n13);

        NaryTreeLevelOrderTraversal n = new NaryTreeLevelOrderTraversal();
        for (List<Integer> list : n.levelOrder(n1)) {
            System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
        }

    }
}
