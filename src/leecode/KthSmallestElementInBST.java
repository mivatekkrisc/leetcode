package leecode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementInBST {

    List<Integer> values = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {

        dfs(root);

        return values.get(k-1);
    }

    public void dfs(TreeNode node) {
        if(node.left != null)
            dfs(node.left);
        values.add(node.val);
        if(node.right != null)
            dfs(node.right);
    }


    public static void main(String args[]) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left= new TreeNode(1);

        KthSmallestElementInBST k = new KthSmallestElementInBST();
        System.out.println(k.kthSmallest(root, 1));
    }

}