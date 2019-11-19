package leecode;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean gl = i == 0 ? true : nums[i] > nums[i - 1];
            boolean gr = i == nums.length - 1 ? true : nums[i] > nums[i + 1];
            if (gl && gr)
                return i;
        }
        return -1;
    }

    public static void main(String args[]) {
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(new int[]{1}));
        System.out.println(f.findPeakElement(new int[]{1, 2, 3}));
        System.out.println(f.findPeakElement(new int[]{3, 2, 1}));
        System.out.println(f.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(f.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
