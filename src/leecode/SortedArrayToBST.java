package leecode;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode root = bst(nums, 0, nums.length - 1, null);
        return root;
    }

    public TreeNode bst(int nums[], int start, int end, TreeNode parent) {
        if (start > end) return parent;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (parent != null) {
            if (node.val > parent.val)
                parent.right = node;
            else
                parent.left = node;
        }
        bst(nums, start, mid - 1, node);
        bst(nums, mid + 1, end, node);

        return node;

    }

    public static void main(String args[]) {
        SortedArrayToBST s = new SortedArrayToBST();
        TreeNode root = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        root = s.sortedArrayToBST(new int[]{0});
        root = s.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5});
        System.out.println(root);
    }
}
