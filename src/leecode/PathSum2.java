package leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, 0, new ArrayList<>(), result);
        return result;
    }

    public void dfs(TreeNode node, int sum, int currentValue, List<Integer> list, List<List<Integer>> result) {

        currentValue += node.val;

        if (node.left == null && node.right == null) {
            if (sum == currentValue) {
                List<Integer> l2 = new ArrayList<>();
                l2.addAll(list);
                l2.add(node.val);
                result.add(l2);
            }
            return;
        }

        if (node.left != null || node.right != null) {

            List<Integer> l2 = new ArrayList<>();
            l2.addAll(list);
            l2.add(node.val);

            if(node.left != null) {
                dfs(node.left, sum, currentValue, l2, result);
            }
            if(node.right != null) {
                dfs(node.right, sum, currentValue, l2, result);
            }
        }

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        for(List<Integer> list : new PathSum2().pathSum(root, 22))
            System.out.println(list.stream().map(i->String.valueOf(i)).collect(Collectors.joining(",")));

        root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        for(List<Integer> list : new PathSum2().pathSum(root, 1))
            System.out.println(list.stream().map(i->String.valueOf(i)).collect(Collectors.joining(",")));

    }
}
