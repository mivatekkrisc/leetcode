package leecode;

public class TailingZeros {

    public int trailingZeroes(int n) {

//        int result = 0;
//        for(int i = 1; i <= n ; i++) {
//            if (i % 10 == 5)
//                result++;
//            int number = i;
//            while (number >= 10 && number % 10 == 0) {
//                number /= 10;
//                result++;
//            }
//        }
//        return result;

        int result = 0;
        while (n >= 5) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }

    public static void main(String args[]) {
//        System.out.println(new TailingZeros().trailingZeroes(3));
//        System.out.println(new TailingZeros().trailingZeroes(5));
//        System.out.println(new TailingZeros().trailingZeroes(10));
//        System.out.println(new TailingZeros().trailingZeroes(15));
        System.out.println(new TailingZeros().trailingZeroes(30));

    }
}
