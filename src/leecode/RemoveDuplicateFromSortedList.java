package leecode;

import java.util.List;

public class RemoveDuplicateFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode n = head.next;
        ListNode pre = head;
        while(n != null) {
            if(n.val == pre.val) {
                pre.next = n.next;
            } else {
                pre = pre.next;
            }
            n = n.next;
        }
        return head;
    }

    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(2);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(1);
        n2.next.next = new ListNode(2);
        n2.next.next.next = new ListNode(3);
        n2.next.next.next.next = new ListNode(3);

        RemoveDuplicateFromSortedList r = new RemoveDuplicateFromSortedList();
        System.out.println(r.deleteDuplicates(n1));
        System.out.println(r.deleteDuplicates(n2));

        n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(2);
        System.out.println(r.deleteDuplicates(n1));
    }
}
