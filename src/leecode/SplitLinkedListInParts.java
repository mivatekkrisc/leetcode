package leecode;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) return new ListNode[k];

        int size = 0;
        ListNode current = root;
        while (current != null) {
            size++;
            current = current.next;
        }
        int count = size / k;
        int remains = size % k;

        ListNode[] result = new ListNode[k];

        current = root;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {

            ListNode part = current;
            result[i] = part;

            int index = 1;
            while (index <= count) {
                prev = current;
                current = current.next;
                index++;
            }
            if (remains > 0) {
                prev = current;
                current = current.next;
                remains--;
            }
            prev.next = null;

        }
        return result;

    }

    public static void main(String args[]) {
        SplitLinkedListInParts s = new SplitLinkedListInParts();

        ListNode head = new ListNode(1);
        ListNode root = head;
        for (int i = 2; i <= 10; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }

        ListNode[] result = s.splitListToParts(root, 4);
        System.out.println(result);
    }
}
