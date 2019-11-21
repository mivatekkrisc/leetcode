package leecode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode s = new ListNode(0), l = new ListNode(0);
        ListNode current = head;
        ListNode sHead = s, lHead = l;

        while (current != null) {

            if (current.val < x) {
                s.next = current;
                s = s.next;
            } else {
                l.next = current;
                l = l.next;
            }
            current = current.next;
        }
        l.next = null;
        s.next = lHead.next;
        return sHead.next;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode result = new PartitionList().partition(head, 7);
        System.out.println(result);
    }
}
