package leecode;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n < 0) return false;

        int bitCount = 0;
        for(int i = 0 ; i < 31; i++) {

            int tmp = n & 1;
            if(tmp == 1) bitCount++;
            n >>= 1;
        }

        return bitCount == 1;
    }

    public static void main(String args[]) {
        PowerOfTwo p = new PowerOfTwo();
        System.out.println(p.isPowerOfTwo(2));
        System.out.println(p.isPowerOfTwo(1));
        System.out.println(p.isPowerOfTwo(64));
        System.out.println(p.isPowerOfTwo(218));
        System.out.println(p.isPowerOfTwo(-2147483648));
        System.out.println(p.isPowerOfTwo(-2147483646));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
