package leecode;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i+1, k = nums.length-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;

                int newDiff = Math.abs(sum - target);
                if(newDiff < diff) {
                    result = sum;
                    diff = newDiff;
                }
                if(sum < target) j++;
                else k--;
            }
        }


        return result;
    }

    public static void main(String args[]) {
        ThreeSumClosest c = new ThreeSumClosest();

        int result = c.threeSumClosest(new int[]{-1,-1,1,1,3}, -1);
//        result = c.threeSumClosest(new int[]{-4,-1,1,2}, 1);
        System.out.println(result);
    }
}
