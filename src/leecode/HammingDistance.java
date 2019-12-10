package leecode;

public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit1 = (x >> i) & 1;
            int bit2 = (y >> i) & 1;
            if (bit1 != bit2) result++;
        }
        return result;
    }

    public static void main(String args[]) {
        HammingDistance h = new HammingDistance();
        System.out.println(h.hammingDistance(1, 4));
    }
}
