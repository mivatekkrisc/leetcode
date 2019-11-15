package leecode;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {

            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = tmp;
        }

    }

    public static void main(String args[]) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        RotateArray r = new RotateArray();
        r.rotate(input, 3);
        for(int i : input)
            System.out.println(i);
    }
}
