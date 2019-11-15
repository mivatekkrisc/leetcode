package leecode;

public class SumRootToLeaf {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int preValue) {

        preValue *= 10;
        preValue += node.val;

        if(node.left == null && node.right == null) {
            sum += preValue;
            return;
        }

        if(node.left != null)
            dfs(node.left, preValue);
        if(node.right != null)
            dfs(node.right, preValue);
    }

    public static void main(String args[]) {
        SumRootToLeaf sum = new SumRootToLeaf();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sum.sumNumbers(root));
    }
}
