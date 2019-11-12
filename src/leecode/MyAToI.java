package leecode;

public class MyAToI {

    public int myAtoi(String s) {
        if (s.length() == 0) return 0;

        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        if (start >= s.length())
            return 0;

        boolean signed = s.charAt(start) == '+' || s.charAt(start) == '-';
        boolean negative = s.charAt(start) == '-' ? true : false;
        if (signed)
            start++;

        int result = 0;
        while (start < s.length() && s.charAt(start) >= '0' && s.charAt(start) <= '9') {

            int pop = s.charAt(start) - '0';
            if (!negative && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop >= 8)))
                return Integer.MAX_VALUE;
            if (negative && (-1 * result < Integer.MIN_VALUE / 10 || (-1 * result == Integer.MIN_VALUE / 10 && pop >= 9)))
                return Integer.MIN_VALUE;
            result *= 10;
            result += pop;
            start++;
        }
        if (negative)
            result = -result;
        return result;
    }

    public static void main(String args[]) {
        MyAToI i = new MyAToI();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
//        System.out.println(i.myAtoi(""));
//        System.out.println(i.myAtoi("42"));
//        System.out.println(i.myAtoi("  -42"));
//        System.out.println(i.myAtoi("4193 with words"));
//        System.out.println(i.myAtoi("words and 987"));
//        System.out.println(i.myAtoi("-91283472332"));
//        System.out.println(i.myAtoi("+1"));
//        System.out.println(i.myAtoi("-"));
//        System.out.println(i.myAtoi(" "));
//        System.out.println(i.myAtoi("2147483648"));
        System.out.println(i.myAtoi("-2147483649"));
    }
}
