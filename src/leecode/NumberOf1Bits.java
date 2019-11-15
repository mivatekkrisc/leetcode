package leecode;

public class NumberOf1Bits {

    public int hammingWeight(int n) {

        int result = 0;
        for(int i = 0; i < 32; i++) {
            if(i == 0)
                result += n & 1;
            else {
                n = n >> 1;
                result += n & 1;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(new NumberOf1Bits().hammingWeight(11));
        System.out.println(new NumberOf1Bits().hammingWeight(128));
    }
}
