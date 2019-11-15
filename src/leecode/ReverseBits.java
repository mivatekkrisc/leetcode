package leecode;

public class ReverseBits {

    public int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {

            int bit = 0;
            if (i > 0) {
                n >>= 1;
            }
            bit = n & 1;
            result |= bit << (31-i);
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(new ReverseBits().reverseBits(2));
    }
}
