package leecode;

public class ClimbStairs {

    public int climbStairs(int n) {
        if(n < 3) return n;

        int result = 0;
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;

    }

    public static void main(String args[]) {
        ClimbStairs c = new ClimbStairs();
//        System.out.println(c.climbStairs(2));
//        System.out.println(c.climbStairs(3));
        System.out.println(c.climbStairs(4));
    }
}
