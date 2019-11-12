package leecode;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int count = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if(nums[i] != pre) {
                pre = nums[i];
                swap(nums, count, i);
                count++;
            }
        }
        return count;

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String args[]) {
        RemoveDuplicates r = new RemoveDuplicates();

        int[] input = new int[]{1,1,2};
//        System.out.println(r.removeDuplicates(input));
//        System.out.println(input[0]+" "+input[1]);

        input = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(r.removeDuplicates(input));

    }
}
