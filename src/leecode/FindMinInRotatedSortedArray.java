package leecode;

public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int min = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < min) min = nums[i];

        return min;
    }

    public static void main(String args[]) {
        FindMinInRotatedSortedArray f = new FindMinInRotatedSortedArray();
        System.out.println(f.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(f.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }


}
