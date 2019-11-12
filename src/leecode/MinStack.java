package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class MinStack {

    List<Integer> stack = new ArrayList<>();
    int minIndex = -1;
    int min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int x) {
        stack.add(x);
        if(x < min) {
            minIndex = stack.size() - 1;
            min = x;
        }
    }

    public void pop() {
        stack.remove(stack.size()-1);
        if(stack.size() > 0) {
            min = stack.get(0);
            minIndex = 0;
            for (int i = 1; i < stack.size(); i++) {
                if(stack.get(i) < min) {
                    min = stack.get(i);
                    minIndex = i;
                }
            }
        }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        if(minIndex != -1) {
            return stack.get(minIndex);
        }
        throw new IllegalArgumentException();
    }

    public static void main(String args[]) {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-1);
        System.out.println(m.getMin());
        System.out.println(m.top());
        m.pop();

        System.out.println(m.getMin());
    }
}
