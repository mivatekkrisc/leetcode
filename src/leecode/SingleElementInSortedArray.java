package leecode;

public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {

        if (nums.length == 1) return nums[0];

        int l = 1, r = nums.length - 2;
        while (l <= r) {
            int lv = nums[l];
            int rv = nums[r];
            if (lv != nums[l - 1])
                return nums[l - 1];
            if (rv != nums[r + 1])
                return nums[r + 1];

            l += 2;
            r -= 2;
        }

        return nums[(l + r) / 2];
    }

    public static void main(String args[]) {
        SingleElementInSortedArray s = new SingleElementInSortedArray();
//        System.out.println(s.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
//        System.out.println(s.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(s.singleNonDuplicate(new int[]{1, 1, 2, 3, 3}));

    }
}
