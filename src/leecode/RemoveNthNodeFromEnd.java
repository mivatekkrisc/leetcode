package leecode;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        int length = 0;
        while(node != null) {
            node = node.next;
            length++;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode dummy = pre;
        node = head;
        int count = 0;
        while(count < length - n) {
            pre = node;
            node = node.next;
            count++;
        }
        pre.next = node.next;
        return dummy.next;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new RemoveNthNodeFromEnd().removeNthFromEnd(head, 2));
        System.out.println(new RemoveNthNodeFromEnd().removeNthFromEnd(new ListNode(1), 1));
    }
}
