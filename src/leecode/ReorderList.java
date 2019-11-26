package leecode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) return;

        List<ListNode> list = new ArrayList<ListNode>();
        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {

            ListNode n1 = list.get(i), n2 = list.get(list.size() - i - 1);
            ListNode preN2 = list.get(list.size()-i-2);
            preN2.next = null;
            n2.next = n1.next;
            n1.next = n2;
        }

    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ReorderList().reorderList(head);
        System.out.println(head);
    }
}
