package leecode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) throw new IllegalArgumentException();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null)
                map.remove(num);
            else
                map.put(num, num);
        }
        return map.values().iterator().next();
    }

    public static void main(String args[]) {
        SingleNumber s = new SingleNumber();
        System.out.println(s.singleNumber(new int[]{2, 2, 1}));
        System.out.println(s.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
