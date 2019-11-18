package leecode;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(tortoise != hare);

        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while(ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }

    public static void main(String args[]) {
        System.out.println(new FindDuplicateNumber().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
