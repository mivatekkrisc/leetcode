package leecode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();

            TreeNode n = q.poll();
            while(n != null) {
                nodes.add(n);
                n = q.poll();
            }

            for(TreeNode node : nodes) {
                list.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(0, list);
        }
        return result;

    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal l = new LevelOrderTraversal();
        List<List<Integer>> result = l.levelOrderBottom(root);

        for (List<Integer> list : result)
            System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
    }
}
