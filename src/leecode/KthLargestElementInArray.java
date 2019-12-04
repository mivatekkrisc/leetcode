package leecode;

import java.util.Arrays;
import java.util.Collections;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String args[]) {
        System.out.println(new KthLargestElementInArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new KthLargestElementInArray().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
