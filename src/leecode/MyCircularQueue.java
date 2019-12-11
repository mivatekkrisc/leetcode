package leecode;

public class MyCircularQueue {

    int capacity;
    int size;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    Node head, tail;

    public MyCircularQueue(int k) {

        this.capacity = k;

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size == capacity) return false;

        if(size == 0) {
            head = new Node(value);
            tail = head;
        } else {
            Node n = new Node(value);
            tail.next = n;
            tail = n;
        }
        size++;
        return true;

    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size == 0) return false;

        if(size > 1)
            head = head.next;
        else {
            head = null;
            tail = null;
        }
        size--;
        return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if(head != null) return head.val;

        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(tail != null) return tail.val;
        return -1;

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;

    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;

    }

    public static void main(String args[]) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(7));  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.Front());  // return true
        System.out.println(circularQueue.deQueue());  // return false, the queue is full
        System.out.println(circularQueue.Front());  // return 3
        System.out.println(circularQueue.Rear());  // return true

        System.out.println(circularQueue.enQueue(0));  // return true
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return 4
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.enQueue(3));

    }
}
