package leecode;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val+"->");

        ListNode node = next;
        while (node != null) {
            builder.append(node.val + "->");
            node = node.next;
        }
        ///builder.append(node.val);

        return builder.toString();
    }
}
