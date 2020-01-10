package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X,";

        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    public TreeNode deserialize(String data) {

        Queue<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(data.split(",")));

        return getNodes(nodes);

    }

    private TreeNode getNodes(Queue<String> nodes) {
        String val = nodes.poll();
        if ("X".equals(val))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = getNodes(nodes);
        node.right = getNodes(nodes);
        return node;
    }

    public static void main(String args[]) {
        Codec c = new Codec();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String result = c.serialize(root);
        System.out.println(result);

        root = c.deserialize(result);
        System.out.println(root.val);
    }
}
