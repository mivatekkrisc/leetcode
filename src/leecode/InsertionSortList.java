package leecode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head.next;
        ListNode next = current.next;

        while (current != null) {

            head = findLocation(head, current);
            current = next;
            if (current != null)
                next = current.next;
        }

        return head;

    }

    public ListNode findLocation(ListNode head, ListNode target) {

        ListNode pre = null, location = null;
        ListNode current = head, next = target.next;
        while (current != null && current != target) {
            if (current.val < target.val) {
                location = current;
            }
            pre = current;
            current = current.next;
        }

        if (location == null) {
            pre.next = target.next;
            target.next = head;
            head = target;
        } else if (location.next == target) {

        }  else {
            pre.next = target.next;
            target.next = location.next;
            location.next = target;
        }
        return head;

    }

    public static void main(String args[]) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        head = new InsertionSortList().insertionSortList(head);
        System.out.println(head);

        head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        System.out.println(new InsertionSortList().insertionSortList(head));

        head = new ListNode(1);
        System.out.println(new InsertionSortList().insertionSortList(head));

    }
}
