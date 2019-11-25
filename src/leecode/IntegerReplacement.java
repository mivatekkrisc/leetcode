package leecode;

public class IntegerReplacement {

    public int integerReplacement(int n) {
        return integerReplacement(n, 0);
    }

    public int integerReplacement(long n, int count) {
        if (n == 1) return count;
        if (n % 2 == 0) return integerReplacement(n / 2, count + 1);
        else {
            return Math.min(integerReplacement(n + 1, count + 1), integerReplacement(n - 1, count + 1));
        }

    }

    public static void main(String args[]) {
//        System.out.println(Integer.MAX_VALUE);
        IntegerReplacement i = new IntegerReplacement();
//        System.out.println(i.integerReplacement(8));
//        System.out.println(i.integerReplacement(7));
        System.out.println(i.integerReplacement(2147483647));
    }
}
