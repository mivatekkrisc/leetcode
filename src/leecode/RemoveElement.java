package leecode;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int nums[], int val) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0 ;
        int i = 0, j = nums.length - 1;
        while(i < j) {
            while(i < j && nums[i] != val) {
                count++;
                i++;
            }
            while(i < j && nums[j] == val) {
                j--;
            }

            if(i < j)
                swap(nums, i, j);
        }
        if(nums[i] != val)
            count++;


        return count;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String args[]) {
        RemoveElement r = new RemoveElement();
        int[] input = new int[]{3, 2, 2, 3};
        System.out.println(r.removeElement(input,3));
        Arrays.stream(input).forEach(System.out::println);

//        input = new int[]{0,1,2,2,3,0,4,2};
//        System.out.println(r.removeElement(input, 2));
//        Arrays.stream(input).forEach(System.out::println);

//        input = new int[]{2};
//        System.out.println(r.removeElement(input, 3));
//        Arrays.stream(input).forEach(System.out::println);
    }
}
