package leecode;

import java.util.Map;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int nums[], int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {

            int remain = target - nums[i];
            if(map.get(remain) != null)
                return new int[]{map.get(remain), i};

            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No result");

    }

    public static void main(String args[]) {
        int[] result = new TwoSum().twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
