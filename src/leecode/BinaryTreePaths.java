package leecode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<String>();
        dfs(root, result, "");
        return result;
    }

    public void dfs(TreeNode node, List<String> result, String prefix) {

        if(node == null) return;
        if(node.left == null && node.right == null) result.add(prefix+node.val);

        dfs(node.left, result, prefix+node.val+"->");
        dfs(node.right, result, prefix+node.val+"->");
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        for(String s : new BinaryTreePaths().binaryTreePaths(root))
            System.out.println(s);
    }
}
