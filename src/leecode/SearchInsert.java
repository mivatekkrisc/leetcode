package leecode;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int start = 0, end = nums.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }


        if (target <= nums[start])
            return start;
        else if (target > nums[end])
            return end + 1;

        return start + 1;

    }

    public static void main(String args[]) {
        SearchInsert s = new SearchInsert();
        int[] input = new int[]{1, 3, 5, 6};

//        System.out.println(s.searchInsert(input, 5));
//        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
//        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(s.searchInsert(new int[]{1}, 1));
        System.out.println(s.searchInsert(new int[]{1,2}, 2));
    }


}
