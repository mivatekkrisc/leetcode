package leecode;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1;
        int index = 0;
        while (i >= 0 || j >= 0) {
            int idx = m + n - 1 - index;
            if (j < 0) nums1[idx] = nums1[i--];
            else if (i < 0) nums1[idx] = nums2[j--];
            else if (nums1[i] > nums2[j]) {
                nums1[idx] = nums1[i--];
            } else {
                nums1[idx] = nums2[j--];
            }
            index++;
        }

    }

    public static void main(String args[]) {
        MergeSortedArray m = new MergeSortedArray();

        int[] input = new int[]{1, 2, 3, 0, 0, 0};
        m.merge(input, 3, new int[]{2, 5, 6}, 3);
        Arrays.stream(input).forEach(System.out::println);

    }
}
