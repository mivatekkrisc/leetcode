package leecode;

public class AddTwoNumber2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode dummy = new ListNode(-1), current = dummy;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            current = current.next;
        }
        if (carry > 0)
            current.next = new ListNode(carry);
        ListNode result = reverse(dummy.next);
        return result;

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;

        }

        return pre;

    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumber2 a = new AddTwoNumber2();

        l1 = new ListNode(5);
        l2 = new ListNode(5);
        System.out.println(a.addTwoNumbers(l1, l2));
    }
}
