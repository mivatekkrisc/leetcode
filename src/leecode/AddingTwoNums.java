package leecode;

public class AddingTwoNums {

    public ListNode addTwoNums(ListNode l1, ListNode l2) {

        ListNode current = new ListNode(0);
        ListNode head = current;

        int carry = 0;

        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null)
                sum += l1.val;
            if(l2 != null)
                sum += l2.val;

            sum += carry;
            current.val = sum >= 10 ? sum - 10 : sum;
            carry = sum >= 10 ? 1 : 0;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

            if(l1 != null || l2 != null || carry > 0) {
                ListNode node = new ListNode(carry);
                current.next = node;
                current = current.next;
            }
        }
        return head;

    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(3);

        l1 = new ListNode(5);
        l2 = new ListNode(5);

        l1 = new ListNode(1);
        l1.next = new ListNode(8);

        l2 = new ListNode(0);

        ListNode result = new AddingTwoNums().addTwoNums(l1, l2);
        System.out.println(result);
    }
}
