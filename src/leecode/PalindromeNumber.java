package leecode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        Deque<Integer> deque = new ArrayDeque<>();
        while(x > 0) {
            deque.push(x % 10);
            x /= 10;
        }

        int pop = -1;
        while(!deque.isEmpty() && deque.size() >= 2) {
            int head = deque.pollFirst();
            int tail = deque.pollLast();
            if(head != tail)
                return false;
        }
        if(deque.size() <= 1)
            return true;

        return false;

    }

    public static void main(String args[]) {
        PalindromeNumber n = new PalindromeNumber();
//        System.out.println(n.isPalindrome(121));
//        System.out.println(n.isPalindrome(-121));
//        System.out.println(n.isPalindrome(10));
        System.out.println(n.isPalindrome(1221));
    }
}
