package leecode;

import java.util.HashSet;
import java.util.Set;

public class MissingNumbers {

    public int missingNumber(int[] nums) {

        int n = nums.length;

        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums)
            set.add(num);

        for(int i = 0 ; i <= n; i++)
            if(!set.contains(i)) return i;

        return -1;
//        for (int i = 0; i <= n; i++)
//            set.add(i);
//
//        for (int num : nums)
//            set.remove(num);
//
//        return set.iterator().next();
    }

    public static void main(String args[]) {
        System.out.println(new MissingNumbers().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new MissingNumbers().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}
