package leecode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        int n = 0;
        ListNode node = head, tail = null;
        while(node != null) {
            if(node.next == null)
                tail = node;
            node = node.next;
            n++;
        }

        int step = n > k ? n - k : n - (k % n);

        ListNode pre = new ListNode(0);
        pre.next = head;
        node = head;

        int count = 0;
        while(count < step) {
            node = node.next;
            pre = pre.next;
            if(node == null) {
                node = head;
            }
            if(pre == null)
                pre = head;
            count++;
        }

        tail.next = head;
        pre.next = null;
        return node;

    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RotateList r = new RotateList();
//        System.out.println(r.rotateRight(head, 2));

        head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        System.out.println(r.rotateRight(head, 4));
    }
}
