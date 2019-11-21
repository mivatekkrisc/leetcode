package leecode;

public class ReverseLinkList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        int count = 1;
        ListNode current = head, nodeM1 = null, nodeM = null, nodeN1 = null;

        ListNode pre = null;
        while (count < m) {
            pre = current;
            current = current.next;
            count++;
        }
        nodeM1 = pre;
        nodeM = current;

        pre = null;
        while (count <= n) {

            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
            count++;
        }
        nodeN1 = current;

        nodeM.next = nodeN1;
        if (nodeM1 != null)
            nodeM1.next = pre;

        if (nodeM1 != null)
            return head;
        else
            return pre;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkList2 r = new ReverseLinkList2();
        head = r.reverseBetween(head, 1, 4);
        System.out.println(head);
    }
}
