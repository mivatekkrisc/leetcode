package leecode;

import java.util.*;

public class LRUCache {

    class Node {
        int key;
        int val;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    int capacity = 0;
    Map<Integer, Node> values = new HashMap<>();
    List<Node> recents;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        recents = new LinkedList<>();
    }

    public int get(int key) {
        Node node = values.get(key);
        if(node != null) {
            recents.remove(node);
            recents.add(node);

        }
        if(node == null)
            return -1;
        return node.val;
    }

    public void put(int key, int value) {

        Node n = values.get(key);
        if(n != null)
            n.val = value;
        else {

            if(recents.size() == capacity) {
                Node evict = recents.remove(0);
                values.remove(evict.key);
            }
            n = new Node(key, value);
            values.put(key, n);
        }

        recents.remove(n);
        recents.add(n);
    }

    public static void main(String args[]) {
        LRUCache c = new LRUCache(10);
        c.put(10,13);
        c.put(3,17);
        c.put(6,11);
        c.put(10,5);
        c.put(9, 10);
        System.out.println(c.get(13));
        c.put(2,19);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        c.put(5,25);
        System.out.println(c.get(8));
        c.put(9,22);
        c.put(5,5);
        c.put(1,30);
        System.out.println(c.get(11));
        c.put(9,12);
        System.out.println(c.get(7));
        System.out.println(c.get(5));
        System.out.println(c.get(8));
        System.out.println(c.get(9));
    }
}
