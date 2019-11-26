package leecode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if (isNumeric(str))
                stack.push(str);
            else {
                if ("+".equals(str)) {
                    String str1 = stack.pop();
                    String str2 = stack.pop();
                    stack.push(Integer.parseInt(str1) + Integer.parseInt(str2) + "");
                } else if ("*".equals(str)) {
                    String str1 = stack.pop();
                    String str2 = stack.pop();
                    stack.push(Integer.parseInt(str1) * Integer.parseInt(str2) + "");
                } else if ("-".equals(str)) {
                    String str1 = stack.pop();
                    String str2 = stack.pop();
                    stack.push(Integer.parseInt(str2) - Integer.parseInt(str1) + "");
                } else if ("/".equals(str)) {
                    String str1 = stack.pop();
                    String str2 = stack.pop();
                    stack.push(Integer.parseInt(str2) / Integer.parseInt(str1) + "");
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isNumeric(String s) {
        return s.charAt(s.length()-1) >= '0' && s.charAt(s.length()-1) <= '9';
    }

    public static void main(String args[]) {
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
//        System.out.println(e.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
//        System.out.println(e.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(e.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
