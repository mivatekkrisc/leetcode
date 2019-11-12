package leecode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    /** Push element x onto stack. */
    public void push(int x) {
        if(!q1.isEmpty())
            q1.offer(x);
        else
            q2.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Integer x = null;
        if(!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                x = q1.poll();

                if(!q1.isEmpty())
                    q2.offer(x);
            }
        } else {
            while(!q2.isEmpty()) {
                x = q2.poll();

                if(!q2.isEmpty())
                    q1.offer(x);
            }
        }
        return x;
    }

    /** Get the top element. */
    public int top() {
        Integer x = null;
        if(!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                x = q1.poll();

                q2.offer(x);
            }
        } else {
            while(!q2.isEmpty()) {
                x = q2.poll();

                q1.offer(x);
            }
        }
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty()) return q2.isEmpty();
        else return q1.isEmpty();
    }

    public static void main(String args[]) {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }


}
