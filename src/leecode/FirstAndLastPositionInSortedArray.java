package leecode;

public class FirstAndLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
//        if(nums.length == 1 && nums[0] == target) return new int[]{0,0};
        int lo = 0, hi = nums.length - 1;

        int min = -1, max = -1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(nums[mid] == target) {
                min = mid;
                max = mid;
                break;
            } else if(nums[mid] > target) {
                hi = mid - 1;
            } else
                lo = mid + 1;
        }

        if(min != -1) {
            while (max + 1 < nums.length && nums[max + 1] == nums[max])
                max++;
            while (min - 1 >= 0 && nums[min - 1] == nums[min])
                min--;
        }

        return new int[]{min, max};
    }

    public static void main(String args[]) {
//        int[] result = new FirstAndLastPositionInSortedArray().searchRange(new int[]{5,7,7,8,8,10}, 6);
//        System.out.println(result[0]+result[1]);

        int[] result = new FirstAndLastPositionInSortedArray().searchRange(new int[]{1}, 1);
        System.out.println(result[0]+result[1]);

//        int[] result = new FirstAndLastPositionInSortedArray().searchRange(new int[]{1,4},4);
//        System.out.println(result[0]+result[1]);
    }
}
