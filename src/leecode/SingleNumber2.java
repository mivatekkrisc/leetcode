package leecode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber2 {

    public int[] singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) return new int[0];

        Set<Integer> result = new HashSet<Integer>();
        for (int num : nums)
            if (result.contains(num))
                result.remove(num);
            else
                result.add(num);


        int[] ret = new int[result.size()];
        int index = 0;
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext())
            ret[index++] = iter.next();
        return ret;

    }

    public static void main(String args[]) {
        SingleNumber2 s = new SingleNumber2();
        System.out.println(s.singleNumber(new int[]{1, 2, 1, 3, 2, 5}).length);
    }
}
