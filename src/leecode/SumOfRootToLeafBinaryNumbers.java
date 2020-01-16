package leecode;

public class SumOfRootToLeafBinaryNumbers {

    int result = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;

        StringBuilder sb = new StringBuilder();
        dfs(root, sb);

        return result;
    }

    public void dfs(TreeNode node, StringBuilder sb) {

        if (node.left == null && node.right == null) {
            result += Integer.parseInt(sb.toString() + node.val, 2);
            return;
        }

        if (node.left != null || node.right != null) {
            StringBuilder cloned = new StringBuilder();
            cloned.append(sb.toString());
            cloned.append("" + node.val);
            if (node.left != null)
                dfs(node.left, cloned);
            if (node.right != null)
                dfs(node.right, cloned);
        }

    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        SumOfRootToLeafBinaryNumbers s = new SumOfRootToLeafBinaryNumbers();
        System.out.println(s.sumRootToLeaf(root));

    }
}
