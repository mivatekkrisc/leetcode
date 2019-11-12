package leecode;

public class MaxProfit {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) return 0;

        int min = prices[0], profit = 0;
        boolean rise = true;
        for (int i = 1; i < prices.length; i++) {

            rise = prices[i] - prices[i - 1] > 0 ? true : false;
            if (!rise && prices[i] < min)
                min = prices[i];

            if(i >= 1 && rise && prices[i] - min > profit)
                profit = prices[i] - min;
        }
        return profit;
    }

    public static void main(String args[]) {
        MaxProfit m = new MaxProfit();
        System.out.println(m.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(m.maxProfit(new int[]{7, 6, 5, 4, 3, 2, 1}));
        System.out.println(m.maxProfit(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
