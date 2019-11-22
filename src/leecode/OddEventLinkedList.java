package leecode;

public class OddEventLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode current = head;
        int count = 1;
        ListNode odd = new ListNode(0), oddHead = odd;
        ListNode even = new ListNode(0), evenHead = even;
        while (current != null) {

            if (count % 2 == 0) {
                even.next = current;
                even = even.next;
            } else {
                odd.next = current;
                odd = odd.next;

            }
            current = current.next;
            if (current == null) {
                if (count % 2 == 0)
                    odd.next = null;
                else
                    even.next = null;
            }
            count++;
        }

        odd.next = evenHead.next;
        return oddHead.next;

    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new OddEventLinkedList().oddEvenList(head));

        head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(new OddEventLinkedList().oddEvenList(head));
    }
}
