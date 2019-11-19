package leecode;

import javax.swing.*;

public class MergeLLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        ListNode min = findMin(lists);
        while (min != null) {
            dummy.next = min;
            dummy = dummy.next;
            min = findMin(lists);
        }
        return head.next;
    }

    public ListNode findMin(ListNode[] lists) {

        int index = 0;
        for (int i = 1; i < lists.length; i++)
            if (lists[i] != null && lists[index] != null && lists[i].val < lists[index].val)
                index = i;
            else if (lists[index] == null && lists[i] != null)
                index = i;

        ListNode result = lists[index];
        if (result != null)
            lists[index] = lists[index].next;
        return result;
    }

    public static void main(String args[]) {
        MergeLLists m = new MergeLLists();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{head1, head2, head3};

        ListNode head = m.mergeKLists(lists);
        System.out.println(head);
    }
}
