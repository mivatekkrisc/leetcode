package leecode;

import java.util.Stack;

public class FlattenMultiLevelDoublyLinkedList {

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    public Node flatten(Node head) {

        if (head == null) return null;

        Node current = head;
        Stack<Node> stack = new Stack<>();

        while (current != null) {
            if (current.child != null) {
                if (current.next != null)
                    stack.push(current.next);
                current.next = current.child;
                current.child = null;
                current.next.prev = current;
                current = current.next;
            } else {
                current = current.next;
            }

            Node prev = null;
            while (current != null && current.next == null && !stack.isEmpty()) {
                Node node = stack.pop();
                if (prev != null)
                    prev.next = node;

                current.next = node;
                node.prev = current;

                current = current.next;
                prev = node;
            }
        }
        return head;
    }

    public static void main(String args[]) {

        Node node1 = new Node(1), node2 = new Node(2), node3 = new Node(3), node4 = new Node(4), node5 = new Node(5), node6 = new Node(6), node7 = new Node(7),
                node8 = new Node(8), node9 = new Node(9), node10 = new Node(10), node11 = new Node(11), node12 = new Node(12), node13 = new Node(13), node14 = new Node(14);

//        node1.next = node2;
//        node2.prev = node1;
//        node2.next = node3;
//        node3.prev = node2;
//        node3.next = node4;
//        node4.prev = node3;
//        node4.next = node5;
//        node5.prev = node4;
//        node5.next =  node6;
//        node6.prev = node5;
//
//        node3.child = node7;
//        node7.next = node8;
//        node8.prev = node7;
//        node8.child = node11;
//        node11.next = node12;
//        node12.prev = node11;
//
//        node8.next = node9;
//        node9.prev = node8;
//        node9.next = node10;
//        node10.prev = node9;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;

        node1.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;
        node10.next = node11;
        node11.prev = node10;

        node9.child = node12;
        node12.next = node13;
        node13.prev = node12;

        node12.child = node14;


        FlattenMultiLevelDoublyLinkedList f = new FlattenMultiLevelDoublyLinkedList();
        Node result = f.flatten(node1);
        System.out.println(result);


    }
}
