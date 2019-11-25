package leecode;

public class LinkedListRandomNode {

    int count = 0;
    ListNode head;

    public LinkedListRandomNode(ListNode head) {

        ListNode current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        this.head = head;

    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {

        int index = (int)(Math.random() * count);

        ListNode current = head;
        for(int i = 0 ; i < index; i++)
            current = current.next;

        return current.val;
    }

    public static void main(String args[]) {
        System.out.println(Math.random() * 3);
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode l = new LinkedListRandomNode(head);
        for(int i = 0; i < 100; i++)
            System.out.println(l.getRandom());

    }
}
