package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    static class Node {
        int val;

        public List<Node> neighbors;

        public Node(int val, List<Node> nodes) {
            this.val = val;
            this.neighbors = nodes;
        }

        public Node() {
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public Node cloneGraph(Node node) {

        Map<Node, Node> map = new HashMap<>(); //key old node, value {new node, new node neighbors}
        return clone(node, map);
    }

    public Node clone(Node node, Map<Node, Node> visited) {

        if(visited.containsKey(node))
            return visited.get(node);

        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new ArrayList<>();
        visited.put(node, newNode);
        for(Node n : node.neighbors) {
            Node neighbor = clone(n, visited);
            newNode.neighbors.add(neighbor);
        }
        return newNode;
    }

    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node clone = new CloneGraph().cloneGraph(n1);
        System.out.println(clone);
    }
}
