package leecode;

public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {

        int l1 = 0, l2 = 0;
        ListNode n1 = head1, n2 = head2;
        while(n1 != null) {
            n1 = n1.next;
            l1++;
        }
        while(n2 != null) {
            n2 = n2.next;
            l2++;
        }

        if(l1 > l2) {
            int diff = l1 - l2;
            while(diff > 0) {
                head1 = head1.next;
                diff--;
            }
        } else {
            int diff = l2 - l1;
            while(diff > 0) {
                head2 = head2.next;
                diff--;
            }

        }

        while(head1 != null && head2 != null && head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        if(head1 == head2)
            return head1;

        return null;
    }

    public static void main(String args[]) {

        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(8);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(0);
        head2.next.next = new ListNode(1);
        head2.next.next.next = head1.next.next;

        IntersectionNode n = new IntersectionNode();
        System.out.println(n.getIntersectionNode(head1, head2));

        head1 = new ListNode(2);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(4);
        head2 = new ListNode(1);
        head2.next = new ListNode(5);
        System.out.println(n.getIntersectionNode(head1, head2));
    }
}
