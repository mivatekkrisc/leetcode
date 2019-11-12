package leecode;

public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode l2 = middle.next;
        ListNode l1 = head;
        middle.next = null;

        l1 = sortList(l1);
        l2 = sortList(l2);
        return mergeSort(l1, l2);
    }

    public ListNode mergeSort(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            } else if(l2 == null) {
                dummy.next = l1;
                l1 = l1.next;
                dummy =dummy.next;
            } else {
                if(l1.val < l2.val) {
                    dummy.next = l1;
                    l1 = l1.next;
                    dummy = dummy.next;
                } else {
                    dummy.next = l2;
                    l2 = l2.next;
                    dummy = dummy.next;
                }
            }
        }
        return head.next;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        System.out.println(new SortList().sortList(head));
    }
}
