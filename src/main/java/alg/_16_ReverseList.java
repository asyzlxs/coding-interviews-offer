package alg;

public class _16_ReverseList {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode reverseHead = null;
        ListNode node = head;
        ListNode prevNode = null;

        while (node != null) {
            ListNode next = node.next;
            if (next == null) reverseHead = node;
            node.next = prevNode;
            prevNode = node;
            node = next;
        }

        return reverseHead;

    }


}
