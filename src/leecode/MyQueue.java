package leecode;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (s1.isEmpty())
            s1.push(x);

        else {

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s2.push(x);
            while (!s2.isEmpty())
                s1.push(s2.pop());
        }

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return s1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return s1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.empty();
    }

    public static void main(String args[]) {
        MyQueue queue = new MyQueue();

        queue.push(1);
//        queue.push(2);
//        int x = queue.peek();  // returns 1
        int y = queue.pop();   // returns 1
//        System.out.println(String.format("x %d y %d, empty %s", x, y, queue.empty()));
        System.out.println(queue.empty()); // returns false
    }

}
