package leecode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if(stack.isEmpty()) return false;
                char pop = stack.pop();
                if((ch == ')' && pop != '(') || (ch == ']' && pop != '[') || (ch == '}' && pop != '{'))
                    return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    public static void main(String args[]) {
        ValidParentheses p = new ValidParentheses();
//        System.out.println(p.isValid("()"));
//        System.out.println(p.isValid("()[]{}"));
//        System.out.println(p.isValid("(]"));
        System.out.println(p.isValid("]"));
    }
}
