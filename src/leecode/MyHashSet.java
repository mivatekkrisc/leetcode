package leecode;

public class MyHashSet {

    private static class Node {
        int val;

        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node[] nodes = new Node[SIZE];
    private static final int SIZE = 10;

    public MyHashSet() {

    }

    public void add(int key) {

        int hash = key % SIZE;
        Node n = nodes[hash];
        if (n == null) {
            nodes[hash] = new Node(key);
        } else {
            Node current = n;
            while (current != null) {
                if (current.val == key)
                    return;

                if (current.next == null)
                    current.next = new Node(key);
                else
                    current = current.next;

            }
        }

    }

    public void remove(int key) {
        int hash = key % SIZE;
        Node n = nodes[hash];
        if (n == null)
            return;

        Node current = n, prev = null;
        while (current != null) {
            if (current.val == key) {
                if (prev == null) {
                    nodes[hash] = current.next;
                    return;
                } else {
                    prev.next = current.next;
                    return;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {

        int hash = key % SIZE;
        Node n = nodes[hash];
        if (n == null) return false;

        Node current = n;
        while (current != null) {
            if (current.val == key)
                return true;
            else
                current = current.next;
        }
        return false;


    }

    public static void main(String args[]) {
        MyHashSet set = new MyHashSet();
        set.add(9);
        set.remove(19);
        set.add(14);
        set.remove(19);
        set.remove(9);
        set.add(0);
        set.add(3);
        set.add(4);
        set.add(0);
        set.remove(9);

//        System.out.println(set.contains(1));
//        System.out.println(set.contains(3));
//        set.add(2);
//        System.out.println(set.contains(2));
//        set.remove(2);
//        System.out.println(set.contains(2));
    }
}
