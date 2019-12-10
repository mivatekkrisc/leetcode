package leecode;

public class MaximumAverageSubArray {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int max = 0, result = 0;
        for (int i = 0; i < k; i++)
            result += nums[i];
        max = result;

        for (int i = 1; i < nums.length - k + 1; i++) {
            result -= nums[i - 1];
            result += nums[k - 1 + i];
            if (result > max)
                max = result;
        }
        return max / (double) k;
    }

    public static void main(String args[]) {
        System.out.println(new MaximumAverageSubArray().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(new MaximumAverageSubArray().findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));
        System.out.println(new MaximumAverageSubArray().findMaxAverage(new int[]{4, 2, 1, 3, 3}, 2));
    }
}
