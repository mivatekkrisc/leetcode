package leecode;

public class BinarySearch {

    public int search(int[] nums, int target) {

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;

    }

    public static void main(String args[]) {

        BinarySearch b = new BinarySearch();
        System.out.println(b.search(new int[]{5}, 5));


    }
}
