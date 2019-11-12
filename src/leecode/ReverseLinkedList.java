package leecode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
//        if(head == null) return head;
//
//        return reverse(head, head.next);

        ListNode pre = null, curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }

    public ListNode reverse(ListNode node, ListNode others) {
        if(others == null) return node;

        node.next = null;
        others = reverse(others, others.next);
        ListNode n = others;
        while(n != null && n.next != null) {
            n = n.next;
        }
        n.next = node;
        return others;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList r = new ReverseLinkedList();
        System.out.println(r.reverseList(head));
    }
}
