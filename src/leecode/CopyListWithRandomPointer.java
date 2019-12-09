package leecode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {

        Node current = head;
        Node cloned = null, clonedPre = null, result = null;
        Map<Node, Node> nodeMap = new HashMap<>();

        while (current != null) {
            cloned = new Node();
            cloned.val = current.val;

            nodeMap.put(current, cloned);
            if (result == null)
                result = cloned;

            if (clonedPre != null)
                clonedPre.next = cloned;

            clonedPre = cloned;
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node random = current.random;
            cloned = nodeMap.get(current);
            Node clonedRandom = nodeMap.get(random);
            cloned.random = clonedRandom;

            current = current.next;
        }

        return result;

    }

    public static void main(String args[]) {
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;

        node1.next = node2;
        node1.random = node2;
        node2.random = node2;

        CopyListWithRandomPointer c = new CopyListWithRandomPointer();
        Node result = c.copyRandomList(node1);
        System.out.println(result);
    }
}
