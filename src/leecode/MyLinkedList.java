package leecode;

public class MyLinkedList {

    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) return -1;

        int i = 0;
        Node current = head;
        while (i <= index) {
            if (i == index)
                return current.val;
            else {
                current = current.next;
            }
            i++;
        }
        return -1;

    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            Node node = new Node(val);
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            Node node = new Node(val);
            tail.next = node;
            tail = node;
        }
        size++;

    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        int i = 0;
        if (index > size) return;

        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        if (index == size) {
            this.addAtTail(val);
            return;
        }


        Node current = head, prev = null;
        while (i < index) {
            prev = current;
            current = current.next;
            i++;
        }
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (index >= size) return;
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        if (index == size - 1) {
            Node current = head, prev = null;
            while (current != null) {
                if (current.next == null) {
                    prev.next = null;
                    tail = prev;
                }
                prev = current;
                current = current.next;
            }
            size--;
            return;
        }

        Node current = head, prev = null;
        int i = 0;
        while (i < index) {
            prev = current;
            current = current.next;
            i++;
        }
        prev.next = current.next;
        size--;
    }

    public static void main(String args[]) {
        MyLinkedList l = new MyLinkedList();
        l.addAtHead(1);
        l.addAtTail(3);
        l.addAtIndex(1, 2);
        System.out.println(l.get(1));
        l.deleteAtIndex(1);
        System.out.println(l.get(1));
    }
}
