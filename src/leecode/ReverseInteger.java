package leecode;

public class ReverseInteger {

    public int reverse(int x) {

        int result = 0;
        while(x != 0) {
            int pop = x % 10;
            x = x/10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            result *= 10;
            result += pop;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(-123 % 10);
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(123));
        System.out.println(r.reverse(-123));
        System.out.println(r.reverse(120));
        System.out.println(r.reverse(1534236469));
        System.out.println(r.reverse(-2147483412));
    }
}
