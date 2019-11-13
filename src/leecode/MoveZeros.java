package leecode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        int index = 0;
        while(index < nums.length && nums[index] != 0) {
            index++;
        }

        for(int i = index + 1 ; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void main(String args[]) {
        MoveZeros m = new MoveZeros();
        int[] input = new int[]{0,1,0,3,12};

        input = new int[]{2,1};
        m.moveZeroes(input);
        System.out.println('a');

    }
}
