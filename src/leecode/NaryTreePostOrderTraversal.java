package leecode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostOrderTraversal {

    public List<Integer> postorder(Node root) {

        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        if(node == null) return;

        if(node.children != null)
            for(Node n : node.children)
                dfs(n, result);

        result.add(node.val);
    }

    public static void main(String[] args) {

        Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3), n4 = new Node(4), n5 = new Node(5), n6 = new Node(6);

        n1.children = List.of(n3, n2, n4);
        n3.children = List.of(n5, n6);

        System.out.println(new NaryTreePostOrderTraversal().postorder(n1));

    }
}
