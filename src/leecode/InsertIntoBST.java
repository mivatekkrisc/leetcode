package leecode;

public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root, parent = null;

        while (current != null) {
            parent = current;
            if (val < current.val)
                current = current.left;
            else if (val > current.val)
                current = current.right;
        }
        TreeNode node = new TreeNode(val);
        if (parent == null)
            return node;

        if (parent.val > val) {
            parent.left = node;
        } else if (parent.val < val) {
            parent.right = node;
        }
        if (root == null)
            return node;
        else
            return root;
    }

    public static void main(String args[]) {
        InsertIntoBST i = new InsertIntoBST();
        TreeNode root = i.insertIntoBST(null, 4);
        TreeNode node = i.insertIntoBST(root, 2);
        node = i.insertIntoBST(root, 7);
        i.insertIntoBST(root, 1);
        i.insertIntoBST(root, 3);
        i.insertIntoBST(root, 5);
        System.out.println(root);
    }
}
