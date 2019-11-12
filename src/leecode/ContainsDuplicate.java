package leecode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i)) return true;
            map.put(i, 1);
        }
        return false;
    }

    public static void main(String args[]) {
        ContainsDuplicate c = new ContainsDuplicate();
        System.out.println(c.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(c.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(c.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
