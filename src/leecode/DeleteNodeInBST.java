package leecode;

public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null || (root.left == null && root.right == null && root.val == key)) return null;
        if(root.val == key && root.left == null) {
            root = root.right;
            return root;
        } else if(root.val == key && root.right == null) {
            root = root.left;
            return root;
        }

        findAndRemove(null, root, key);
        return root;
    }

    public void findAndRemove(TreeNode parent, TreeNode node, int key) {
        if (node.val == key) {

            if (node.left == null && node.right == null) { //case1
                if (node == parent.left) parent.left = null;
                else parent.right = null;
            } else if (node.left == null || node.right == null) { //case2
                if (node.left == null) {
                    if (parent.left == node) parent.left = node.right;
                    else parent.right = node.right;
                } else {
                    if (parent.left == node) parent.left = node.left;
                    else parent.right = node.left;
                }
            } else {
                Integer successor = null;
                TreeNode current = node.right, target = null, targetParent = node;
                while (current != null) {
                    successor = current.val;
                    target = current;
                    current = current.left;
                    if(current != null) targetParent = target;
                }
                findAndRemove(targetParent, target, target.val);
                node.val = successor;
            }
        } else if (key > node.val && node.right != null)
            findAndRemove(node, node.right, key);
        else if (key < node.val && node.left != null)
            findAndRemove(node, node.left, key);

    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        DeleteNodeInBST d = new DeleteNodeInBST();
//        d.deleteNode(root, 5);
//        System.out.println(d);
//
//        root = new TreeNode(5);
//        root = d.deleteNode(root, 5);
//        System.out.println(root);

        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root = d.deleteNode(root, 1);
        System.out.println(root);




    }
}
