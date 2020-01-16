package leecode;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int[] result = new int[cost.length + 1];
        result[0] = 0;
        result[1] = 0;

        for (int i = 2; i < result.length; i++)
            result[i] = Math.min(cost[i - 2] + result[i - 2], cost[i - 1] + result[i - 1]);

        return result[result.length - 1];

    }

//    public int minCost(int[] cost, int dest) {
//
//        if (dest == 0) return 0;
//
//        return Math.min(minCost(cost, dest - 1), minCost(cost, dest - 2));
//    }

    public static void main(String args[]) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        System.out.println(m.minCostClimbingStairs(new int[]{10, 15, 20}));

        System.out.println(m.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
