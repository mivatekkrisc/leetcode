package leecode;

public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {

        if(root.val == val)
            return root;
        else if(root.left != null && val < root.val)
            return searchBST(root.left, val);
        else if(root.right != null && val > root.val)
            return searchBST(root.right, val);
        else
            return null;

    }


}
