package leecode;

public class MaxProfix2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int buy = prices[0];
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += (prices[i] - prices[i - 1]);
            } else
                buy = prices[i];
        }
        return result;

    }

    public static void main(String args[]) {
        MaxProfix2 m = new MaxProfix2();
        System.out.println(m.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(m.maxProfit(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(m.maxProfit(new int[]{5, 4, 3, 2, 1}));
    }
}
