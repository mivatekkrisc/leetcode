package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        dfs(root, result);

        return result;
    }

    public void dfs(TreeNode node, List<Integer> result) {
        if(node == null) return;

        dfs(node.left, result);
        dfs(node.right, result);
        result.add(node.val);

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = new BinaryTreePostorderTraversal().postorderTraversal(root);
        System.out.println(result.stream().map(i->String.valueOf(i)).collect(Collectors.joining(",")));

    }
}
