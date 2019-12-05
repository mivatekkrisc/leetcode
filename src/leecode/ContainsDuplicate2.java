package leecode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && i - index <= k)
                return true;
            else
                map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String args[]) {
        ContainsDuplicate2 c = new ContainsDuplicate2();
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(c.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
