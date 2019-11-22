package leecode;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {

        if (n == 1) return true;
        if (n < 3) return false;

        int remain = 0;
        int count = 0;
        while (n >= 3 && remain == 0) {
            remain = n % 3;
            n /= 3;
            count++;
        }
//        System.out.println("count: "+count);
        return remain == 0 && n == 1;

    }

    public static void main(String args[]) {
        PowerOfThree p = new PowerOfThree();
        System.out.println(p.isPowerOfThree(27));
        System.out.println(p.isPowerOfThree(0));
        System.out.println(p.isPowerOfThree(9));
        System.out.println(p.isPowerOfThree(45));
        System.out.println(p.isPowerOfThree(19684));
        System.out.println(p.isPowerOfThree(6));
    }
}
