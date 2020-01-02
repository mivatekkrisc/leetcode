package leecode;

import java.util.ArrayList;
import java.util.Stack;

public class BSTIterator {

    private TreeNode root;
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {

        this.root = root;
        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode current = node.right;

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iter = new BSTIterator(root);
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
    }
}
