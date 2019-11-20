package leecode;

public class UglyNumber {

    public boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;

        int[] primes = new int[]{2, 3, 5};

        int remain = 0;
        for (int prime : primes) {

            while (num % prime == 0) {
                num = num / prime;
            }
        }
        return num == 1;
    }

    public static void main(String args[]) {
        UglyNumber u = new UglyNumber();
//        System.out.println(u.isUgly(6));
//        System.out.println(u.isUgly(8));
//        System.out.println(u.isUgly(14));
        System.out.println(u.isUgly(-2147483648));
    }
}
