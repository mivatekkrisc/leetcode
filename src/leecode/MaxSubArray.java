package leecode;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            sum += nums[i];
            if(nums[i] > max) max = nums[i];
            if(nums[i] > sum) sum = nums[i];

            if(sum > max)
                max = sum;
        }

        return max;
    }

    public static void main(String args[]) {
        MaxSubArray m = new MaxSubArray();
        System.out.println(m.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(m.maxSubArray(new int[]{1,2}));
    }
}
