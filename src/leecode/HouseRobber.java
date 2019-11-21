package leecode;

public class HouseRobber {

    public int rob(int[] nums) {

        int[] max = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; i--)
            max[i] = Math.max(nums[i] + max[i + 2], max[i + 1]);

        return max[0];

    }
}
