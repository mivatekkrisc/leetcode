package leecode;

public class MyCircularDeque {

    int capacity;
    int size;

    Node head, tail;

    static class Node {
        int val;
        Node next;
        Node pre;

        public Node(int val) {
            this.val = val;
        }
    }

    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if(isFull()) return false;

        if(size == 0) {
            head = new Node(value);
            tail = head;
        } else {
            Node n = new Node(value);
            n.next = head;
            head.pre = n;
            head = n;
        }

        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if(isFull()) return false;

        if(size == 0) {
            head = new Node(value);
            tail = head;
        } else {
            Node n = new Node(value);
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if(isEmpty()) return false;

        if(size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = null;
        }
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            tail.next = null;
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if(isEmpty()) return -1;
        return head.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if(isEmpty()) return -1;
        return tail.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String args[]) {
        MyCircularDeque d = new MyCircularDeque(3);
        System.out.println(d.insertLast(1));
        System.out.println(d.insertLast(2));
        System.out.println(d.insertFront(3));
        System.out.println(d.insertFront(4));
        System.out.println(d.getRear());
        System.out.println(d.isFull());
        System.out.println(d.deleteLast());
        System.out.println(d.insertFront(4));
        System.out.println(d.getFront());
    }
}
