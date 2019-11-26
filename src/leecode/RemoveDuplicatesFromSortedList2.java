package leecode;

public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode current = head, pre = null;
        int val = current.val;

        while (current != null) {
            if (current.next != null && current.next.val == val) {
                while (current != null && current.val == val)
                    current = current.next;

                if (pre == null)
                    head = current;
                else
                    pre.next = current;
            } else {
                pre = current;
                current = current.next;
            }
            if (current != null)
                val = current.val;
        }
        return head;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        System.out.println(new RemoveDuplicatesFromSortedList2().deleteDuplicates(head));

        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        System.out.println(new RemoveDuplicatesFromSortedList2().deleteDuplicates(head));

        head = new ListNode(1);
        head.next = new ListNode(1);
        System.out.println(new RemoveDuplicatesFromSortedList2().deleteDuplicates(head));
    }
}
