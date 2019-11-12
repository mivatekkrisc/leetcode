package leecode;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeOrderTraversal {

    private class C {
        private TreeNode node;
        private int level;

        private C(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = null;
        Queue<C> queue = new LinkedList<>();

        queue.offer(new C(root, 1));

        while(!queue.isEmpty()) {
            C c = queue.remove();
            if(result.size() < c.level) {
                current = new ArrayList<>();
                result.add(current);
            }
            current.add(c.node.val);

            if(c.node.left != null) queue.offer(new C(c.node.left, c.level+1));
            if(c.node.right != null) queue.offer(new C(c.node.right, c.level+1));
        }

        return result;


//        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
//        dfs(root, 1, map);
//
//        List<List<Integer>> result = new ArrayList<>();
//        for(Integer level : map.keySet())
//            result.add(map.get(level));
//        return result;
    }

    public void dfs(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if(node == null) return;

        if(map.get(level) == null)
            map.put(level, new ArrayList<>());
        map.get(level).add(node.val);

        dfs(node.left, level+1, map);
        dfs(node.right, level+1, map);
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeOrderTraversal b = new BinaryTreeOrderTraversal();
        for(List<Integer> list : b.levelOrder(root))
            System.out.println(list.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));

    }
}
