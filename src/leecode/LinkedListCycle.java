package leecode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode n1 = head;
        ListNode n2 = n1.next;

        while (n1 != null && n2 != null && n1 != n2) {
            n2 = n2.next != null ? n2.next.next : null;
            n1 = n1.next;
        }

        if (n1 == n2)
            return true;

        return false;
    }

    public static void main(String args[]) {
        ListNode n1 = new ListNode(3);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(0);
        n1.next.next.next = new ListNode(-4);
        n1.next.next.next.next = n1;

        LinkedListCycle l = new LinkedListCycle();
        System.out.println(l.hasCycle(n1));

        n1 = new ListNode(1);
        System.out.println(l.hasCycle(n1));

        n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = n1;
        System.out.println(l.hasCycle(n1));

    }
}
