package leecode;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode head = node;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                node.next = l2;
                l2 = l2.next;
            } else if(l2 == null) {
                node.next = l1;
                l1 = l1.next;
            } else if(l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        return head.next;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeTwoSortedList m = new MergeTwoSortedList();
        System.out.println(m.mergeTwoLists(l1, l2));

    }
}
