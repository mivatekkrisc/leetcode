package leecode;

public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head.next, fast = head.next.next;

        while (slow != null && fast != null && fast != slow) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : fast.next;
        }
        if (slow != fast)
            return null;

        ListNode current = head;
        while (true) {
            if (current == slow)
                return current;
            slow = slow.next;
            current = current.next;
        }
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;

        System.out.println(new LinkedListCycle2().detectCycle(head).val);
        head = new ListNode(1);

    }
}
