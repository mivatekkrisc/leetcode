package leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length/2];
//        if(nums.length == 1) return nums[0];
//        int majorCount = nums.length / 2;
//
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer val = map.get(nums[i]);
//            if (val == null)
//                map.put(nums[i], 1);
//            else {
//                if (val + 1 > majorCount)
//                    return nums[i];
//                map.put(nums[i], val+1);
//            }
//        }
//        return -1;
    }

    public static void main(String args[]) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));

    }
}
