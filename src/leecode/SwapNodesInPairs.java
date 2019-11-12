package leecode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while(head != null && head.next != null) {
            ListNode n1 = head, n2 = head.next;
            n1.next = n2.next;
            n2.next = n1;
            pre.next = n2;

            head = head.next;
            pre = n1;
        }
        return dummy.next;
    }

    public static void main(String args[]) {
        SwapNodesInPairs s = new SwapNodesInPairs();
//        System.out.println(s.swapPairs(new ListNode(1)));

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(s.swapPairs(head));
    }
}
