package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BSTInOrder {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList();
        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode node, List<Integer> result) {
        if (node == null) return;

        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BSTInOrder b = new BSTInOrder();
        System.out.println(b.inorderTraversal(root).stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
    }
}
