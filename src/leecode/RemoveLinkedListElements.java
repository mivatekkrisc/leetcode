package leecode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode first = dummy;
        dummy.next = head;

        while(head != null) {
            if(head.val == val)
                dummy.next = head.next;
            else
                dummy = dummy.next;
            head = head.next;
        }

        return first.next;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        RemoveLinkedListElements r = new RemoveLinkedListElements();
        System.out.println(r.removeElements(head, 6));

    }
}
