package leecode;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> nums = new HashSet<Integer>();

        int[] s = nums1.length > nums2.length ? nums2 : nums1;
        for (int num : s)
            nums.add(num);

        int[] l = nums1.length > nums2.length ? nums1 : nums2;
        List<Integer> list = new ArrayList<Integer>();

        for (int num : l)
            if (nums.contains(num)) {
                list.add(num);
                nums.remove(num);
                if (nums.size() == 0) break;
            }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }

    public static void main(String args[]) {

        IntersectionOfTwoArrays i = new IntersectionOfTwoArrays();
        int[] result = i.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int num : result)
            System.out.println(num);

        for (int num : i.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))
            System.out.println(num);

    }
}