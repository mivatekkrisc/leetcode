package leecode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int foundIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                foundIndex = i;
                break;
            }
        }


        int result = binarySearch(nums, target, 0, foundIndex - 1);
        if (result != -1)
            return result;
        return binarySearch(nums, target, foundIndex, nums.length - 1);

    }

    public int binarySearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                return binarySearch(nums, target, l, mid - 1);
            else
                return binarySearch(nums, target, mid + 1, r);
        }
        return -1;
    }

    public static void main(String args[]) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
